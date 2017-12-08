package bte.init;

import bte.main.Main;
import bte.objects.items.CustomItem2;
import bte.objects.items.ItemBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemInit {
	public static Item testItem = new CustomItem2("item2", 2);
	private static final Item[] ITEMS = {
			testItem
	};
	public static void register(IForgeRegistry<Item> event) {
		event.registerAll(ITEMS);
	}
	
	public static void registerModels(ModelRegistryEvent event) {
		for(Item item : ITEMS) {
			Main.proxy.registerItemRenderer(item, 0, "inventory");
		}
	}
}
