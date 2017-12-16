package bte.proxy;

import bte.main.Vars;
import bte.objects.blocks.tile.TileGpStorage;
import bte.objects.blocks.tile.TileGrowthGen;
import bte.objects.blocks.tile.TileHive;
import bte.util.helpers.StringHelper;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Server {
	public void registerItemRenderer(Item item, int meta, String ID) {

		
	}
	
	public void registerTileEnitities() {
		GameRegistry.registerTileEntity(TileHive.class, StringHelper.GRS("tilehive"));
		GameRegistry.registerTileEntity(TileGrowthGen.class, StringHelper.GRS("tilegpgen"));
		GameRegistry.registerTileEntity(TileGpStorage.class, StringHelper.GRS("grpbattery"));
	}

	public void preInit(FMLPreInitializationEvent event) {

	}
}
