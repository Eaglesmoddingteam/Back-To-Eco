package bte.util.entityhelper;

import java.util.Map;

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
	
	static Map<ItemStack, ItemStack> recipes;
	
	public static void InitRecipes() {
	recipes = FurnaceRecipes.instance().getSmeltingList();	
	}
	
	public static EntityItem burn(ItemStack input, double x, double y, double z, World world) {
		if(recipes.containsKey(input)) {
			ItemStack out = recipes.get(input);
			out.setCount(out.getCount() + (int)((Math.random() * 2) * out.getCount() + 1));
			EntityItem output = new EntityItem(world, x, y, z, out);
			return output;
		}
		return null;
	}
	
}
