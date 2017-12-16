package bte.init;

import bte.client.renders.RenderInfernalBlacksmith;
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
		int id= 1;
		EntityRegistry.registerModEntity(new ResourceLocation(Vars.MOD_ID, "infernal_blacksmith"),
				EntityBlacksmith.class, "InfernalBlacksmith", id++, Main.instance, 10,
				3, true, 0xFF8C00, 0xCC4B00);
	}

	@SideOnly(Side.CLIENT)
	public static void initModels() {
		RenderingRegistry.registerEntityRenderingHandler(EntityBlacksmith.class, new RenderInfernalBlacksmith.Factory());
	}
}
