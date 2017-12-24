package bte.util.entityhelper;

import java.util.Map;
import java.util.Random;

import akka.actor.IndirectActorProducer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistry;

public class BurnHelper {
	static Random rand = new Random();
	
	
	public static EntityItem burn(ItemStack input, double x, double y, double z, World world) {
			ItemStack dummy = input.copy();
			dummy.setCount(1);
			ItemStack out = FurnaceRecipes.instance().getSmeltingResult(dummy);
			if(!out.isEmpty()) {
			out.setCount(input.getCount() + rand.nextInt(2));
			EntityItem output = new EntityItem(world, x, y, z, out);
			return output;
			}
			return null;
	}
	
}
