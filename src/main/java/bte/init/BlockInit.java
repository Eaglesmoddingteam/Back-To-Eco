package bte.init;

import bte.main.Main;
import bte.objects.blocks.BlockBase;
import bte.objects.blocks.BlockGPStorage;
import bte.objects.blocks.BlockGrowthGen;
import bte.objects.blocks.BlockPylon;
import bte.util.GrPUtil.GrPConductHelper.PylonTypes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockInit {
	
	public static BlockPylon pylon1 = new BlockPylon("terrallic_pylon", Material.ROCK, btf.main.Main.blocksTab, 2, PylonTypes.TERRALIC);
	public static BlockPylon joint = new BlockPylon("joint_pylon", Material.ROCK, btf.main.Main.blocksTab, 2, PylonTypes.JOINT);
	public static BlockGPStorage GrowthStorage = new BlockGPStorage("gpbattery", Material.ROCK, btf.main.Main.blocksTab, 2);
	public static BlockGrowthGen GrowthGen = new BlockGrowthGen("growth_gen", Material.ROCK, btf.main.Main.blocksTab, 2);
	
	public static Block[] BLOCKS = {
			GrowthGen,
			GrowthStorage,
			pylon1,
			joint
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
