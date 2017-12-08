package bte.objects.blocks.tile;

import java.util.HashMap;

import btf.util.energy.IGrowthPotentialStorage;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.storage.WorldInfo;

public class TileGrowthGen extends TileEntity implements IGrowthPotentialStorage, ITickable {
	boolean initialized = false;
	int GPIn = 0;
	int X=0;
	int Z=0;
	int startX=pos.getX();
	int y=pos.getY();
	int startZ=pos.getZ();
	BlockPos scanning;
	IGrowthPotentialStorage[] outputs = new IGrowthPotentialStorage[2];
	HashMap<BlockPos, Integer> extracted = new HashMap<BlockPos, Integer>();
	
	private void init(){
		initialized = true;
		startX=pos.getX() - 1;
		startZ=pos.getZ() - 1;
		y=pos.getY();
	}
	@Override
	public int receiveGP(int maxReceive, boolean simulate) {
		return 0;
	}

	@Override
	public int extractGP(int maxExtract, boolean simulate) {
		if(maxExtract<=10) {
			if(!simulate)
			GPIn-=10;
			return 10;
		}else{
			if(!simulate)
			GPIn-=maxExtract;
			return maxExtract;
		}
	}

	@Override
	public int getGPStored() {
		return GPIn;
	}

	@Override
	public int getGPCapacity() {
		return 20;
	}

	@Override
	public boolean canExtract() {
		return true;
	}

	@Override
	public boolean canReceive() {
		return false;
	}

	@Override
	public void update() {
	if(!initialized) {
		init();
	}
	if(!isFull()) {
	scanning = new BlockPos(startX+X, y, startZ+Z);
	if(world.getBlockState(scanning).getBlock() == Blocks.SAPLING) {
		GPIn++;
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
	} else if(world.getBlockState(scanning).getBlock() == Blocks.LOG || world.getBlockState(scanning).getBlock() == Blocks.LOG2) {
		if(extracted.containsKey(scanning)) {
			extracted.remove(scanning);
		}
	}
	
	}
		//moves GrowthPotential to the 2 blocks at the top and the bottom
		for(IGrowthPotentialStorage output : outputs) {
			if(output!=null) {				
				if(!(output instanceof TilePylon)) {
					GPIn-=output.receiveGP(10, false);
				} else {
					TilePylon out = (TilePylon) output;
					GPIn-=out.sendGP(10);
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
		return GPIn == 20;
	}

	public void setOutput(IGrowthPotentialStorage outputs, EnumFacing blockFacingFromTEPos) {
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
	public void onChunkUnload() {
		markDirty();
		super.onChunkUnload();
	}
	

}
