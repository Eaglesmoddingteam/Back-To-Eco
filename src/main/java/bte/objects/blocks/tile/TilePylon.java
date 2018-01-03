package bte.objects.blocks.tile;

import com.google.common.collect.ComputationException;

import bte.util.GrPUtil.GrPConductHelper.PylonTypes;
import bte.util.helpers.MathHelper;
import btf.util.energy.CapabilityGrowthPotential;
import btf.util.energy.IGrowthPotentialStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TilePylon extends TileEntity{
	MathHelper mh = MathHelper.INSTANCE;
	PylonTypes typeIn;
	boolean isOutput = true;
	TilePylon next;
	IGrowthPotentialStorage output;
	TileEntity outputte;
	
	public TilePylon(PylonTypes type) {
		if(type == PylonTypes.JOINT)
			isOutput = false;
		this.typeIn = type;
		
		if(world.getTileEntity(pos.add(0, -1, 0)) != null ){
			TileEntity te = world.getTileEntity(pos.add(0, -1, 0));
			if(te.hasCapability(CapabilityGrowthPotential.GROWTHPOTENTIAL, null)) {
				this.output = te.getCapability(CapabilityGrowthPotential.GROWTHPOTENTIAL, null);
				this.outputte = te;
			}
		}
	}
	
	public void connect(TilePylon next, EntityPlayer playerIn) {
		this.isOutput = false;
		this.next = next;
	}
	
	public int fire(int amount) {
		if(next.isOutput) {
			return next.insert(amount);
		}
		return next.fire(amount);
	}
	
	private int insert(int amount) {
		if(output != null) {
			return output.receiveGP(amount, false);
		}
		return 0;
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setBoolean("isOutPut", isOutput);
		if(!isOutput)
		compound.setIntArray("next", mh.CVA(next.pos));
		if(isOutput)
		compound.setIntArray("output", mh.CVA(outputte.getPos()));
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.isOutput = compound.getBoolean("isOutPut");
		if(!isOutput)
		next = (TilePylon) world.getTileEntity(mh.GBVA(compound.getIntArray("next")));
		if(isOutput)
		outputte = world.getTileEntity(mh.GBVA(compound.getIntArray("output")));
		output = outputte.getCapability(CapabilityGrowthPotential.GROWTHPOTENTIAL, null);
		super.readFromNBT(compound);
	}
	
	@Override
	public void onChunkUnload() {
		this.markDirty();
		super.onChunkUnload();
	}
	
}
