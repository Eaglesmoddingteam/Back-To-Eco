package bte.proxy;

import bte.client.renders.TESRGrowthGen;
import bte.init.EntityInit;
import bte.objects.blocks.tile.TileGrowthGen;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Client extends Server{

	@Override
	public void registerItemRenderer(Item item, int meta, String ID) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), ID));
	}
	
	@Override
	public void registerrenders() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileGrowthGen.class, new TESRGrowthGen());
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		
		EntityInit.initModels();
	}
}
