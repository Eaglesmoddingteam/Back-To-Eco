package bte.objects.blocks.tile;

import java.util.HashMap;

import btf.util.energy.IGrowthPotentialStorage;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileGrowthGen extends TileEntity implements IGrowthPotentialStorage, ITickable {
	int GPIn = 0;
	int X=0;
	int Z=0;
	int startX=pos.getX()-1;
	int y=pos.getY();
	int startZ=pos.getZ()-1;
	BlockPos scanning;
	IGrowthPotentialStorage[] outputs = new IGrowthPotentialStorage[2];
	
	HashMap<BlockPos, Integer> extracted = new HashMap<BlockPos, Integer>();
	
	@Override
	public int receiveGP(int maxReceive, boolean simulate) {
		return 0;
	}

	@Override
	public int extractGP(int maxExtract, boolean simulate) {
		if(maxExtract<=10) {
			GPIn-=10;
			return 10;
		}else{
			GPIn=maxExtract;
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
		if(isFull()) {
	scanning = new BlockPos(startX+X, y, startZ+Z);
	if(world.getBlockState(scanning).getBlock() == Blocks.SAPLING) {
		GPIn++;
		if(extracted.containsKey(scanning)) {
			extracted.replace(scanning, extracted.get(scanning)+1);
			if(extracted.get(scanning) == 200) {
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
	for(IGrowthPotentialStorage output : outputs) {
		GPIn+=output.receiveGP(10, false);
	}
	}
	}

	private boolean isFull() {
		return GPIn == 20;
	}

}
