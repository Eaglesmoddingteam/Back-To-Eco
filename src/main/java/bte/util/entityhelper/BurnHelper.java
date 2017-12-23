package bte.util.entityhelper;

import akka.actor.IndirectActorProducer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BurnHelper {
	
	public static EntityItem burn(ItemStack input, double x, double y, double z, World world) {
		Item item = input.getItem();
		int amount = input.getCount();
		if(item == item.getItemFromBlock(Blocks.IRON_ORE)) {
			EntityItem output = new EntityItem(world, x, y, z, new ItemStack(Items.IRON_INGOT, amount * (int) (Math.random() + 2)));
			return output;
		}
		
		if(item == item.getItemFromBlock(Blocks.GOLD_ORE)) {
			EntityItem output = new EntityItem(world, x, y, z, new ItemStack(Items.GOLD_INGOT, amount * (int) (Math.random() + 2)));
			return output;
		}
		
		if(item == item.getItemFromBlock(Blocks.DIAMOND_ORE)) {
			EntityItem output = new EntityItem(world, x, y, z, new ItemStack(Items.DIAMOND, amount * (int) (Math.random() + 2)));
			return output;
		}
		
		if(item == item.getItemFromBlock(Blocks.REDSTONE_ORE)) {
			EntityItem output = new EntityItem(world, x, y, z, new ItemStack(Items.REDSTONE, amount * (int) (Math.random() * 13 + 12)));
			return output;
		}
		
		return null;
	}
	
}
