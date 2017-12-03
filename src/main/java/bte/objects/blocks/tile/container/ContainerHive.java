package bte.objects.blocks.tile.container;

import bte.objects.blocks.tile.TileHive;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerHive extends Container {

	private TileHive te;

	public ContainerHive(IInventory playerInventory, TileHive te) {
		 this.te = te;

	        // This container references items out of our own inventory (the 9 slots we hold ourselves)
	        // as well as the slots from the player inventory so that the user can transfer items between
	        // both inventories. The two calls below make sure that slots are defined for both inventories.
	        addOwnSlots();
			addPlayerSlots(playerInventory);
	}
	

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}


    private void addPlayerSlots(IInventory playerInventory) {
        // Slots for the main inventory
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                int x = 9 + col * 18;
                int y = row * 18 + 70;
                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 10, x, y));
            }
        }

        // Slots for the hotbar
        for (int row = 0; row < 9; ++row) {
            int x = 9 + row * 18;
            int y = 58 + 70;
            this.addSlotToContainer(new Slot(playerInventory, row, x, y));
        }
    }
    
    private void addOwnSlots() {
        IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        int x = 9;
        int y = 6;

        // Add our own slots
        int slotIndex = 0;
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y));
            slotIndex++;
            x += 18;
        }

}


	public void markDirty() {
		// TODO Auto-generated method stub
		
	}
}
