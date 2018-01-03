package bte.main;

import java.util.Random;

import bte.init.EntityInit;
import bte.init.ItemInit;
import bte.proxy.Server;
import bte.util.entityhelper.BurnHelper;
import bte.util.handlers.RegistryHandler;
import btf.init.FurnaceRecipeInit;
import btf.util.registry.FurnaceRegisty;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
		proxy.registerrenders();
	}
	
	@Mod.EventHandler
	public static void init(FMLInitializationEvent event){
		proxy.registerTileEnitities();
	}
	
	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event){

	}
}
