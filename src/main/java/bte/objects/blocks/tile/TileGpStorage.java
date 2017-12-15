package bte.objects.blocks.tile;

import btf.util.energy.IGrowthPotentialStorage;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileGpStorage extends TileEntity implements IGrowthPotentialStorage, ITickable{
	
	private boolean initialized=false;
	private int GPIn;
	private IGrowthPotentialStorage[] outputs=new IGrowthPotentialStorage[4];

	private void init() {
		initialized=true;
	}
	
	@Override
	public int receiveGP(int maxReceive, boolean simulate) {
		if(!(GPIn + maxReceive > getGPCapacity())) {
		if(maxReceive>=10) {
			if(!simulate)
			GPIn+=10;
			return 10;
		}else{
			if(!simulate)
			GPIn+=maxReceive;
			return maxReceive;
		}
		}
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
		return 200;
	}

	@Override
	public boolean canExtract() {
		return true;
	}

	@Override
	public boolean canReceive() {
		return true;
	}

	@Override
	public void update() {
		for (IGrowthPotentialStorage output : outputs) {
			if(output!=null) {
				if(GPIn > 20) {
				GPIn-=output.receiveGP(20, false);
				} else if(GPIn>0)
				GPIn-=output.receiveGP(GPIn, false);
			}
		}
	}
	
	public void addOutput(IGrowthPotentialStorage output, EnumFacing exportSide) {
		switch (exportSide) {
		case DOWN:
			break;
		case EAST:
			outputs[0]=output;
			break;
		case NORTH:
			outputs[1]=output;
			break;
		case SOUTH:
			outputs[2]=output;
			break;
		case UP:
			break;
		case WEST:
			outputs[3]=output;
			break;		
		}
	}

	@Override
	public void onChunkUnload() {
		markDirty();
	}
}
