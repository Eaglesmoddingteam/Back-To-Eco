package bte.init;

import bte.main.Main;
import bte.objects.blocks.BlockBase;
import bte.objects.blocks.BlockBeeHive;
import bte.objects.blocks.BlockGPStorage;
import bte.objects.blocks.BlockGrowthGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockInit {
	
	public static BlockGPStorage GrowthStorage = new BlockGPStorage("gpbattery", Material.ROCK, btf.main.Main.blocksTab, 2);
	public static BlockGrowthGen GrowthGen = new BlockGrowthGen("growth_gen", Material.ROCK, btf.main.Main.blocksTab, 2);
	public static BlockBeeHive BeeHive = new BlockBeeHive("hivebees", Material.WOOD, CreativeTabs.BUILDING_BLOCKS);
	
	public static Block[] BLOCKS = {
			GrowthGen,
			BeeHive,
			GrowthStorage
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

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent registryEvent) {
		for (Block block: BLOCKS)
			Main.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
	}
}
