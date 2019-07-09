package com.bteteam.bte;

import com.bteteam.bte.helper.ReflectCollector;
import com.bteteam.bte.helper.StreamHelper;
import com.bteteam.bte.registries.block.obj.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class EventHandler {

	@SubscribeEvent
	public void onRegisterBlocks(RegistryEvent.Register<Block> blockRegistryEvent) {
		IForgeRegistry<Block> registry = blockRegistryEvent.getRegistry();
		ReflectCollector.getEntries(Main.BLOCKS_REGISTRY).forEach(registry::register);
	}

	@SubscribeEvent
	public void onRegisterItems(RegistryEvent.Register<Item> itemRegistryEvent) {
		IForgeRegistry<Item> registry = itemRegistryEvent.getRegistry();
		ReflectCollector.getEntries(Main.ITEMS_REGISTRY).forEach(registry::register);
		ReflectCollector.streamEntries(Main.BLOCKS_REGISTRY).map(b->(BlockBase) b).map(BlockBase::getItemBlocks).forEach(registry::registerAll);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onRegisterModels(ModelRegistryEvent event) {
		ReflectCollector.streamEntries(Main.ITEMS_REGISTRY).forEach(item ->Main.proxy.registerItemRenderer(item, 0,"inventory"));
		StreamHelper.combine(ReflectCollector.streamEntries(Main.BLOCKS_REGISTRY).map(b->(BlockBase) b).map(BlockBase::getItemBlocks)).forEach(item -> Main.proxy.registerItemRenderer(item, 0, "inventory"));
	}


}
