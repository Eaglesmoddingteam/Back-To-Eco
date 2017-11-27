package bte.init;

import bte.main.Main;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemInit {
	
	
	private static final Item[] ITEMS = {
			//lol
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
