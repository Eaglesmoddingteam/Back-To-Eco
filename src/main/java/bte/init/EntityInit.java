package bte.init;

import bte.entity.utilitymobs.EntityBlacksmith;
import bte.main.Main;
import bte.main.Vars;
import bte.util.helpers.StringHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	
	public static void registerEntities() {
		int id= 1;
		registerEntity("infernal_blacksmith", EntityBlacksmith.class, id++, 10, 16729856, 16711680);
	}

	private static void registerEntity(String name, Class<? extends Entity> entityClass, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(StringHelper.GR(name), entityClass, name, id, Main.instance, range, 1, true, color1, color2);
	}

	
}
