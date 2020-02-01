package com.bteteam.bte;

import com.bteteam.bte.blocks.Blocks;
import com.bteteam.bte.blocks.tileentities.TileEntityInfernalForge;
import com.bteteam.bte.blocks.tileentities.TileEntityTypes;
import com.bteteam.bte.client.RenderInfernalBlacksmith;
import com.bteteam.bte.client.RenderInfernalForge;
import com.bteteam.bte.entity.Entities;
import com.bteteam.bte.entity.InfernalBlackSmithEntity;
import com.bteteam.bte.net.NetHandler;
import com.bteteam.bte.summoning.recipe.SummoningRecipe;
import com.bteteam.bte.summoning.recipe.SummoningRecipes;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

import java.util.Arrays;

@Mod(Main.MODID)
public class Main {

	public static final String MODID = "backtoeco";
	public static final String NAME = "Back to Eco";
	public static final String VERSION = "V0.1.0";

	public Main() {
		Mod.EventBusSubscriber.Bus.FORGE.bus().get().register(new EventHandler());
		Mod.EventBusSubscriber.Bus.MOD.bus().get().register(new EventHandler());
		NetHandler.init();
	}

	public static class EventHandler {

		@SubscribeEvent
		public void registerBlocks(RegistryEvent.Register<Block> event) {
			Arrays.stream(Blocks.class.getFields()).filter(field -> field.getType() == Block.class).map(field -> {
				try {
					return ((Block) field.get(null)).setRegistryName(Main.MODID, field.getName());
				} catch (IllegalAccessException e) {
					return null;
				}
			}).forEach(event.getRegistry()::register);
		}

		@SubscribeEvent
		public void registerItems(RegistryEvent.Register<Item> event) {
			Arrays.stream(Blocks.class.getFields()).filter(field -> field.getType() == Block.class).map(field -> {
				try {
					return new BlockItem(((Block) field.get(null)), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(Main.MODID, field.getName());
				} catch (IllegalAccessException e) {
					return null;
				}
			}).forEach(event.getRegistry()::register);
		}

		@SubscribeEvent
		public void registerTileEntities(RegistryEvent.Register<TileEntityType<?>> event) {
			Arrays.stream(TileEntityTypes.class.getFields()).filter(field -> field.getType() == TileEntityType.class).map(field -> {
				try {
					return ((TileEntityType<?>) field.get(null)).setRegistryName(new ResourceLocation(Main.MODID, field.getName()));
				} catch (IllegalAccessException e) {
					return null;
				}
			}).forEach(event.getRegistry()::register);
		}

		@SubscribeEvent
		public void registerSummoningRecipes(RegistryEvent.Register<SummoningRecipe> event) {
			Arrays.stream(SummoningRecipes.class.getFields()).filter(field -> field.getType() == SummoningRecipe.class).map(field -> {
				try {
					return ((SummoningRecipe) field.get(null)).setRegistryName(new ResourceLocation(Main.MODID, field.getName()));
				} catch (IllegalAccessException e) {
					return null;
				}
			}).forEach(event.getRegistry()::register);
		}

		@SubscribeEvent
		public void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
			Arrays.stream(Entities.class.getFields()).filter(field -> field.getType() == EntityType.class).map(field -> {
				try {
					return ((EntityType<?>) field.get(null)).setRegistryName(new ResourceLocation(Main.MODID, field.getName()));
				} catch (IllegalAccessException e) {
					return null;
				}
			}).forEach(event.getRegistry()::register);
		}

		@SubscribeEvent
		public void addRegistries(RegistryEvent.NewRegistry event) {
			RegistryBuilder<SummoningRecipe> builder = new RegistryBuilder<>();
			ResourceLocation location = new ResourceLocation(Main.MODID, "spawning_entries");
			builder.setType(SummoningRecipe.class);
			builder.setName(location);
			IForgeRegistry<SummoningRecipe> forgeRegistry = builder.create();
			Mod.EventBusSubscriber.Bus.MOD.bus().get().post(new RegistryEvent.Register<>(location, forgeRegistry));
			SummoningRecipe.recipes = forgeRegistry;
		}

		@SubscribeEvent
		public void onClientSetup(FMLClientSetupEvent event) {
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInfernalForge.class, new RenderInfernalForge());
			RenderingRegistry.registerEntityRenderingHandler(InfernalBlackSmithEntity.class, new RenderInfernalBlacksmith());
		}
	}
}
