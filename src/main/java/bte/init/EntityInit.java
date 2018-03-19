package bte.init;

import bte.client.renders.RenderHorseshoeCrab;
import bte.client.renders.RenderInfernalBlacksmith;
import bte.client.renders.RenderTortoise;
import bte.entity.animal.AnimalHorseshoeCrab;
import bte.entity.animal.AnimalTortoise;
import bte.entity.utilitymobs.EntityBlacksmith;
import bte.main.Main;
import bte.main.Vars;
import bte.util.helpers.StringHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityTracker;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityInit {

	public static void registerEntities() {
		int id = 1;
		EntityRegistry.registerModEntity(new ResourceLocation(Vars.MOD_ID, "infernal_blacksmith"),
				EntityBlacksmith.class, "InfernalBlacksmith", id++, Main.instance, 10, 3, true, 0xFF8C00, 0xCC4B00);
		EntityRegistry.registerModEntity(StringHelper.GR("tortoise"), AnimalTortoise.class, "Tortoise", id++,
				Main.instance, 10, 3, true, 0x6C4C1F, 0x17D259);
		EntityRegistry.registerModEntity(StringHelper.GR("horseshoecrab"), AnimalHorseshoeCrab.class, "HoseShoeCrab", id++, Main.instance, 10, 8, true, 0xc26f3d, 0xc2c2bc);
	}

	@SideOnly(Side.CLIENT)
	public static void initModels() {
		RenderingRegistry.registerEntityRenderingHandler(EntityBlacksmith.class,
				new RenderInfernalBlacksmith.Factory());
		RenderingRegistry.registerEntityRenderingHandler(AnimalTortoise.class, new RenderTortoise.Factory());
		RenderingRegistry.registerEntityRenderingHandler(AnimalHorseshoeCrab.class, new RenderHorseshoeCrab.Factory());
	}
}
