package bte.main;

import bte.proxy.Server;
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

	@SubscribeEvent
	public static void preInit(FMLPreInitializationEvent event){
		
	}
	
	@SubscribeEvent
	public static void Init(FMLInitializationEvent event){
		
	}
	
	@SubscribeEvent
	public static void PostInit(FMLPostInitializationEvent event){
		
	}
}
