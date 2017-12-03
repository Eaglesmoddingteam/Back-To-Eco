package bte.objects.blocks.tile;

import java.util.Random;

import com.jcraft.jorbis.Block;

import bte.objects.blocks.tile.container.ContainerHive;
import bte.objects.items.bees.ItemBee;
import net.minecraft.block.BlockFlower;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;


public class TileHive extends TileEntity implements ITickable{
	int flowers = 0;
	Item queen = null;
	ItemStack[] bees = new ItemStack[3];
	
	private int ticksIn=0;
	boolean outcome=false;
	
	public static final int SIZE = 9;

    // This item handler will hold our nine inventory slots
    private ItemStackHandler itemStackHandler = new ItemStackHandler(SIZE) {
        @Override
        protected void onContentsChanged(int slot) {
           
        }
    };

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("items")) {
            itemStackHandler.deserializeNBT((NBTTagCompound) compound.getTag("items"));
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setTag("items", itemStackHandler.serializeNBT());
        return compound;
    }

    public boolean canInteractWith(EntityPlayer playerIn) {
        // If we are too far away from this tile entity you cannot use it
        return !isInvalid() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(itemStackHandler);
        }
        return super.getCapability(capability, facing);
    }


	@Override
	public void update() {
		if (ticksIn == 0) {
			flowers=0;
	        for (int x = -10; x <= 10; x++) {
	            for (int y = -1; y <= 1; y++) {
	                for (int z =-10; z <= 10; z++) {
	                    net.minecraft.block.Block block = world.getBlockState(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z)).getBlock();
	                    if (block instanceof BlockFlower) {
	                        flowers++;
	                    }
	                }
	            }
	       
	        } 
	        outcome=true;
		}
		if(!outcome) {
			//init recipes
		}
		if(isDone()) {
			ticksIn = -1;
		}
		ticksIn++;
	}
	
	private int getprogress() {
		return ticksIn / 20;
	}
	
	private boolean isDone() {
		return getprogress() == 100;
	}

}
