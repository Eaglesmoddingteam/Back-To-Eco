package bte.init;

import bte.main.BTETabs;
import bte.main.Main;
import bte.objects.items.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemInit {
	static BTETabs t = BTETabs.INSTANCE;
	
	public static ItemBase picker_ant = new ItemBase("picker_ant", t.bugstab);
	public static ItemBase queen_ant = new ItemBase("queen_ant", t.bugstab);
	public static ItemBase worker_ant = new ItemBase("worker_ant", t.bugstab);
	public static ItemBase beatle = new ItemBase("beatle", t.bugstab);
	public static ItemBase blue_beatle = new ItemBase("blue_beatle", t.bugstab);
	public static ItemBase bee = new ItemBase("bee", t.bugstab);
	public static ItemBase alien_bee = new ItemBase("alien_bee", t.bugstab);
	public static ItemBase jungle_bee = new ItemBase("jungle_bee", t.bugstab);
	public static ItemBase queen_bee = new ItemBase("queen_bee", t.bugstab);
	public static ItemBase alien_queen = new ItemBase("queen_alien", t.bugstab);
	public static ItemBase jungle_queen = new ItemBase("queen_jungle", t.bugstab);
	public static ItemBase butterfly = new ItemBase("butterfly", t.bugstab);
	public static ItemBase dragonfly = new ItemBase("dragonfly", t.bugstab);
	public static ItemBase dragonfly2 = new ItemBase("dragonfly2", t.bugstab);
	public static ItemBase dragonfly3 = new ItemBase("dragonfly3", t.bugstab);
	public static ItemBase earthworm = new ItemBase("earthworm", t.bugstab);
	public static ItemBase firefly = new ItemBase("firefly", t.bugstab);
	public static ItemBase ladybird = new ItemBase("ladybird", t.bugstab);
	public static ItemBase moth = new ItemBase("moth", t.bugstab);
	public static ItemBase pinchbug = new ItemBase("pinchbug", t.bugstab);
	public static ItemBase shrimp = new ItemBase("shrimp", t.bugstab);
	public static ItemBase silkworm = new ItemBase("silkworm", t.bugstab);
	public static ItemBase wasp = new ItemBase("wasp", t.bugstab);
	public static ItemBase worm = new ItemBase("worm", t.bugstab);
	
	
	public static Item[] bugs = {
			alien_bee,alien_queen,beatle,bee,blue_beatle,butterfly,dragonfly,dragonfly2,dragonfly3,earthworm,firefly,jungle_bee,jungle_queen,ladybird,moth,picker_ant,pinchbug,queen_ant,queen_bee,shrimp,silkworm,wasp,worker_ant,worm
			};

	
	private static final Item[] ITEMS = {
			alien_bee,
			alien_queen,
			beatle,
			bee,
			blue_beatle,
			butterfly,
			dragonfly,
			dragonfly2,
			dragonfly3,
			earthworm,
			firefly,
			jungle_bee,
			jungle_queen,
			ladybird,
			moth,
			picker_ant,
			pinchbug,
			queen_ant,
			queen_bee,
			shrimp,
			silkworm,
			wasp,
			worker_ant,
			worm
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
