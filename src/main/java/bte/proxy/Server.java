package bte.proxy;

import bte.main.Vars;
import bte.objects.blocks.tile.TileGrowthGen;
import bte.objects.blocks.tile.TileHive;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Server {
	public void registerItemRenderer(Item item, int meta, String ID) {

		
	}
	
	public void registerTileEnitities() {
		GameRegistry.registerTileEntity(TileHive.class, Vars.MOD_ID + ":" + "tilehive");
		GameRegistry.registerTileEntity(TileGrowthGen.class, Vars.MOD_ID + ":" + "tilegpgen");
	}
}
