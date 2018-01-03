package bte.objects.blocks.tile;

import java.util.HashMap;

import bte.util.helpers.MathHelper;
import btf.util.energy.CapabilityGrowthPotential;
import btf.util.energy.GrowthPotentialStorage;
import btf.util.energy.IGrowthPotentialStorage;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.capabilities.Capability;

public class TileGrowthGen extends TileEntity implements ITickable {
	MathHelper mh = MathHelper.INSTANCE;
	IGrowthPotentialStorage out;
	boolean initialized = false;
	int X=0;
	int Z=0;
	int startX=pos.getX();
	int y=pos.getY();
	int startZ=pos.getZ();
	BlockPos scanning;
	TileEntity[] outputs = new TileEntity[2];
	HashMap<BlockPos, Integer> extracted = new HashMap<BlockPos, Integer>();
	GrowthPotentialStorage storage;
	
	Capability<IGrowthPotentialStorage> capability = CapabilityGrowthPotential.GROWTHPOTENTIAL;
	
	public TileGrowthGen() {
		storage  = new GrowthPotentialStorage(60, 1, 10, 0);
	}
	
	public int GPIn() {
		return storage.getGPStored();
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setInteger("gp", GPIn());
			if(outputs[0] != null)
			compound.setIntArray("up", mh.CVA(outputs[0].getPos()));
			if(outputs[1] != null)
			compound.setIntArray("down", mh.CVA(outputs[1].getPos()));
		return super.writeToNBT(compound);
	}
	
	void readIntVectorArray(int[] array, String type){
		switch(type) {
		case "d":
			outputs[1] = world.getTileEntity(mh.GBVA(array));
			break;
		case "u":
			outputs[0] = world.getTileEntity(mh.GBVA(array));
			break;
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		storage = new GrowthPotentialStorage(60, 1, 10, compound.getInteger("gp"));
		readIntVectorArray(compound.getIntArray("up"), "u");
		readIntVectorArray(compound.getIntArray("down"), "d");
		super.readFromNBT(compound);
	}
	
	private void init(){
		initialized = true;
		startX=pos.getX() - 1;
		startZ=pos.getZ() - 1;
		y=pos.getY();
	}
	
	@Override
	public void update() {
	if(!initialized) {
		init();
	}
	if(!isFull()) {
	scanning = new BlockPos(startX+X, y, startZ+Z);
	if(world.getBlockState(scanning).getBlock() == Blocks.SAPLING) {
		storage.receiveGP(1, false);
		if(extracted.containsKey(scanning)) {
			extracted.replace(scanning, extracted.get(scanning)+1);
			world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, scanning.getX(), scanning.getY(), scanning.getZ(), 2, 2, 2, 1,1);
			if(extracted.get(scanning) == 10) {
				extracted.remove(scanning);
				world.setBlockState(scanning, Blocks.DEADBUSH.getDefaultState());
				}
		} else {
			extracted.put(scanning, 1);
		}
	} else if(world.getBlockState(scanning).getBlock() == Blocks.LOG || world.getBlockState(scanning).getBlock() == Blocks.LOG2 ||  world.getBlockState(scanning).getBlock() == Blocks.AIR) {
		if(extracted.containsKey(scanning)) {
			extracted.remove(scanning);
		}
	}
	
	}
		//moves GrowthPotential to the 2 blocks at the top and the bottom 
		for(TileEntity output : outputs) {
			if(output!=null) {
				if(output.hasCapability(CapabilityGrowthPotential.GROWTHPOTENTIAL, null))
					out = output.getCapability(CapabilityGrowthPotential.GROWTHPOTENTIAL, null);
				if(!(output instanceof TilePylon)) {
					if(GPIn() > 10) {
					 storage.extractGP(out.receiveGP(10, false), false);
					} else if (GPIn() > 0 ){
					 storage.extractGP(out.receiveGP(GPIn(), false), false);
					}
				} else {
					TilePylon out = (TilePylon) output;
					if(GPIn() > 10) {
						 //TODO -10 GPIn-=out.sendGP(10);
						} else {
							//TODO -GPIn GPIn-=GPIn-=out.sendGP(GPIn);
						}
				}
			}
	}
		X++;
		if(X==4) {
			X=0;Z++;
			if(Z==4) {
				X=0;Z=0;
			}
		}
	}

	private boolean isFull() {
		return GPIn() == 20;
	}

	public void setOutput(TileEntity outputs, EnumFacing blockFacingFromTEPos) throws IllegalArgumentException{
		switch(blockFacingFromTEPos){
		default:
			throw new IllegalArgumentException("Only Facing Down and Up Accepted");
		case UP:
			this.outputs[0]=outputs;
			break;
		case DOWN:
			this.outputs[1]=outputs;
			break;
		}
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == this.capability;
	}
	
	@Override
	public void onChunkUnload() {
		this.markDirty();
		super.onChunkUnload();
	}

}
