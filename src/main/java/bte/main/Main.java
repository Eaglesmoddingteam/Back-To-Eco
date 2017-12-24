package bte.main;

import bte.init.EntityInit;
import bte.proxy.Server;
import bte.util.entityhelper.BurnHelper;
import bte.util.handlers.RegistryHandler;
import btf.init.FurnaceRecipeInit;
import btf.util.registry.FurnaceRegisty;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Vars.MOD_ID, version = Vars.MOD_VERSION, name = Vars.MOD_NAME)
public class Main {
	
	@Mod.Instance
	public static Main instance;
	
	@SidedProxy(clientSide = "bte.proxy.Client", serverSide = "bte.proxy.Server")
	public static Server proxy;

	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event){
		EntityInit.registerEntities();
		proxy.preInit(event);
	}
	
	@Mod.EventHandler
	public static void init(FMLInitializationEvent event){

	}
	
	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event){

	}
}
