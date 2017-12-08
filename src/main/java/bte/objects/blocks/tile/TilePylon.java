package bte.objects.blocks.tile;

import com.mojang.text2speech.NarratorOSX;

import bte.util.GrPUtil.GrPConductHelper.PylonTypes;
import bte.util.helpers.MathHelper;
import btf.util.energy.IGrowthPotentialStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class TilePylon extends TileEntity implements IGrowthPotentialStorage{
	private PylonTypes typePylon;
	int maxTransferRate=0;
	boolean isJoint = false;
	TilePylon nextPylon;
	IGrowthPotentialStorage output=null;
	
	public TilePylon(PylonTypes typePylon) {
		this.typePylon=typePylon;
		init();
	}
	
	public void connect(TilePylon TileIn, EntityPlayer connector) {
		if(MathHelper.GPUI((pos.getX() - TileIn.pos.getX()), pos.getZ()-TileIn.pos.getZ()) > 20) {
		//errors
		} else if (MathHelper.GPUI((pos.getX() - TileIn.pos.getX()), pos.getZ()-TileIn.pos.getZ()) <=0){
		//errors
		} else {
			this.nextPylon = TileIn;
		}
	}
	
	private void init() {
		switch(typePylon) {
		case CELESTIAL:
			maxTransferRate=30;
			break;
		case JOINT:
			isJoint = true;
			maxTransferRate=0;
			break;
		case NAZZU:
			maxTransferRate=30;
			break;
		case TERRALIC:
			maxTransferRate=30;
			break;
		}
		
		if(typePylon != PylonTypes.JOINT) {
			TileEntity TileEntityOn = world.getTileEntity(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()));
			if(TileEntityOn instanceof IGrowthPotentialStorage) {
				IGrowthPotentialStorage output = (IGrowthPotentialStorage) TileEntityOn;
				this.output = output;
			}
		}
	}
	
	public boolean fireToNext(int amount) {
		if (nextPylon != null)
		if(nextPylon.isJoint) {
		return nextPylon.fireToNext(amount);
		} else {
		return false;	
		}
		return false;
	}
	
	public boolean AcceptGP(int amount) {
		if(output != null) {
		if(output.canReceive()) {
			if(output.receiveGP(amount, true) <= amount) {
				output.receiveGP(amount, false);
				return true;
			}
		}
		}
		return false;
	}
	
	public int sendGP(int amount) {
		if(amount > maxTransferRate) {
			amount = maxTransferRate;
		}
		for(int i = amount; i >= 0; i--){
			if(nextPylon != null) {
				if(nextPylon.isJoint) {
					if (nextPylon.fireToNext(i)) {
						return i;
					}
					} else {	
						if (nextPylon.AcceptGP(i)) {
							return i;
						}
					}
			}
		}
		return 0;
	}

	
	/*
	 * This class simulates the Growth Potential Storage
	 * The methods are implemented to fit the capatablity system
	 */
	
	
	
	@Override
	public int receiveGP(int maxReceive, boolean simulate) {
		return 0;
	}

	@Override
	public int extractGP(int maxExtract, boolean simulate) {
		return 0;
	}

	@Override
	public int getGPStored() {
		return 0;
	}

	@Override
	public int getGPCapacity() {
		return 0;
	}

	@Override
	public boolean canExtract() {
		return false;
	}

	@Override
	public boolean canReceive() {
		return false;
	}
}
