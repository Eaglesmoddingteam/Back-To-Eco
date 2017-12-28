package bte.util.handlers;

import btf.init.ItemInit;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventHandler {
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void ontoss(ItemTossEvent event) {
		EntityItem itemThrown = event.getEntityItem();
		World worldIn = itemThrown.world;
		
		if(itemThrown.getItem().getItem() == ItemInit.brass) {
		worldIn.spawnEntity(new EntityItem(worldIn, itemThrown.posX, itemThrown.posY, itemThrown.posZ, new ItemStack(ItemInit.cobalt)));
		itemThrown.setDead();
		}
	}

}
