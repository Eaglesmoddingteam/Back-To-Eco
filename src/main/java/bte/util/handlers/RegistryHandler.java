package bte.util.handlers;

import bte.init.BlockInit;
import bte.init.EntityInit;
import bte.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;

import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraftforge.event.RegistryEvent;

import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;



@Mod.EventBusSubscriber

public class RegistryHandler {



	@SubscribeEvent

	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		ItemInit.register(event.getRegistry());
		BlockInit.registerItemBlocks(event.getRegistry());
	}



	@SubscribeEvent

	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		BlockInit.register(event.getRegistry());
	}



	@SubscribeEvent

	public static void onModelRegister(ModelRegistryEvent event) {
		ItemInit.registerModels(event);
		BlockInit.registerModels(event);
	}
}