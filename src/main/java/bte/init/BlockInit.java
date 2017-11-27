package bte.init;

import bte.objects.blocks.BlockBeeHive;
import btf.main.Main;
import btf.objects.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockInit {

	public static BlockBase BeeHive = new BlockBeeHive("hivebees", Material.WOOD, CreativeTabs.BUILDING_BLOCKS);
	
	public static Block[] BLOCKS = {
			BeeHive
	};
	
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(BLOCKS);
	}

	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		for (Block block: BLOCKS) {
			BlockBase blockBase = (BlockBase) block;
			registry.register(blockBase.createItemBlock());
		}
	}

	public static void registerModels(ModelRegistryEvent registryEvent) {
		for (Block block: BLOCKS)
			Main.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
	}
}
