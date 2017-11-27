package bte.objects.blocks.tile;

import java.util.Random;

import com.jcraft.jorbis.Block;

import bte.objects.items.bees.ItemBee;
import net.minecraft.block.BlockFlower;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;


public class TileHive extends TileEntity implements ITickable{
	public InventoryBasic hiveInv = new InventoryBasic(new TextComponentString("Hive"), 4);
	public InventoryBasic output = new InventoryBasic(new TextComponentString("outputs"), 4);
	int flowers = 0;
	Item queen = null;
	ItemStack[] bees = new ItemStack[3];
	
	private int ticksIn=0;
	boolean outcome=false;

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
	        outcome=initbees();
		}
		if(isDone()) {
			if(outcome) {
				FinishRecipe();
			} else {
				flowers=0;
				FinishRecipe();
			}
		}
		ticksIn++;
	}
	
	private int getprogress() {
		return ticksIn / 20;
	}
	
	private boolean isDone() {
		return getprogress() == 100;
	}
	
	/**
	 * Cleans up the Arrays to make room for a new batch of bees.
	 * Also gets the outcome of the recipes and puts it into the output inv.
	 * Gets called after the process is equal to 100.
	 **/
	public void FinishRecipe() {
		ticksIn=-1;
		for (int i=0;i<=bees.length;i++) {
			bees[i] = null;
		}
		queen = null;
		int i= 0;
		for(ItemStack stack:getOutcomes()) {
			output.setInventorySlotContents(i, stack);
			i++;
		}
	}
	
	boolean initbees() {
		for(int i = 0; i <= hiveInv.getSizeInventory(); i++) {
			if (i == 0 && hiveInv.getStackInSlot(i).getItem() instanceof ItemBee) {
				ItemBee casted = (ItemBee) hiveInv.getStackInSlot(i).getItem();
				if(casted.isQueen()) {
					queen=hiveInv.getStackInSlot(i).getItem();
				}
			} else if (hiveInv.getStackInSlot(i).getItem() instanceof ItemBee) {
				if(queen==null) {
				return false;
				} else{
					ItemBee beeIn = (ItemBee) hiveInv.getStackInSlot(i).getItem();
					if(beeIn.isWorkerOf((ItemBee)this.queen)) {
						bees[i-1]= new ItemStack(hiveInv.getStackInSlot(i).getItem());
					}
				}
			}
		}
		return true;
	}
	Random rand = new Random();
	
	Item wax=null;
	Item honey=null;
	private ItemStack[] getOutcomes() {
		ItemStack[] out= new ItemStack[] {
				new ItemStack(wax, 1*flowers/10),
				new ItemStack(honey, rand.nextInt(3)/3*flowers/10),
				new ItemStack(((ItemBee) queen).getWorker(), rand.nextInt(19)/19*flowers/10)
				};
		return out;
	}
	
	

	

}
