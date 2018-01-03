package bte.objects.blocks.tile;

import javax.annotation.Nullable;

import bte.util.helpers.MathHelper;
import btf.util.energy.CapabilityGrowthPotential;
import btf.util.energy.GrowthPotentialStorage;
import btf.util.energy.IGrowthPotentialStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class TileGpStorage extends TileEntity implements ITickable{
	MathHelper mh = MathHelper.INSTANCE;
	
	Capability<IGrowthPotentialStorage> GrPc = CapabilityGrowthPotential.GROWTHPOTENTIAL;
	GrowthPotentialStorage GrPs;
	TileEntity[] outputs = new TileEntity[4];

	public TileGpStorage() {
		GrPs = new GrowthPotentialStorage(200, 20, 20, 0);
	}
	
	
	@Override
	public void update() {
		for(TileEntity te : outputs) {
			if(te != null)
			if(te.hasCapability(CapabilityGrowthPotential.GROWTHPOTENTIAL, null)) {
				IGrowthPotentialStorage out = te.getCapability(CapabilityGrowthPotential.GROWTHPOTENTIAL, null);
				if(out.canReceive()&& out.getGPCapacity() > out.getGPStored()) {
					GrPs.receiveGP(out.receiveGP(20, false), false);
				}
			}
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		if(outputs[0] != null)
		compound.setIntArray("west", mh.CVA(outputs[0].getPos()));
		if(outputs[1] != null)
		compound.setIntArray("east", mh.CVA(outputs[1].getPos()));
		if(outputs[2] != null)
		compound.setIntArray("north", mh.CVA(outputs[2].getPos()));
		if(outputs[3] != null)
		compound.setIntArray("south", mh.CVA(outputs[3].getPos()));
		compound.setInteger("grp", GrPs.getGPStored());
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		readIntVectorArray(compound.getIntArray("north"), "n");
		readIntVectorArray(compound.getIntArray("east"), "e");
		readIntVectorArray(compound.getIntArray("south"), "s");
		readIntVectorArray(compound.getIntArray("west"), "w");
		GrPs = new GrowthPotentialStorage(200, 10, 20, compound.getInteger("grp"));
		super.readFromNBT(compound);
	}
	
	void readIntVectorArray(int[] array, String type){
		switch(type) {
		case "n":
			outputs[2] = world.getTileEntity(mh.GBVA(array));
			break;
		case "e":
			outputs[1] = world.getTileEntity(mh.GBVA(array));
			break;
		case "s":
			outputs[3] = world.getTileEntity(mh.GBVA(array));
			break;
		case "w":
			outputs[0] = world.getTileEntity(mh.GBVA(array));
			break;
		}
	}

	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		if(capability.equals(GrPc)) {
			return (T) GrPs;
		}
		return null;
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		if(capability.equals(GrPc)) {
			return true;
		}
		return false;
	}

	public void addOutput(TileEntity neighbour, EnumFacing side) {
		switch(side) {
		case DOWN:
			break;
		case EAST:
			outputs[1] = neighbour;
			break;
		case NORTH:
			outputs[2] = neighbour;
			break;
		case SOUTH:
			outputs[3] = neighbour;
			break;
		case UP:
			break;
		case WEST:
			outputs[0] = neighbour;
			break;
			
		
		}
	}


	public int GPIn() {
		return GrPs.getGPStored();
	}
	
	@Override
	public void onChunkUnload() {
		this.markDirty();
		super.onChunkUnload();
	}
	
	
}