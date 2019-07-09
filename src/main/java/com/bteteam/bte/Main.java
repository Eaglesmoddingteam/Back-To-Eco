package com.bteteam.bte;

import com.bteteam.bte.registries.block.Blocks;
import com.bteteam.bte.registries.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Main.Constants.modid, version = Main.Constants.version, name = Main.Constants.modName)
public class Main {

	EventHandler eventHandler = new EventHandler();

	public static Blocks BLOCKS_REGISTRY;
	public static Items ITEMS_REGISTRY;

	@Mod.Instance
	public static Main instance;

	@SidedProxy(clientSide = "com.bteteam.proxy.client.Client", serverSide = "com.bteteam.proxy.server.Server")
	public static Proxy proxy;


	public Main() {
		MinecraftForge.EVENT_BUS.register(eventHandler);
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {

	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	public static class Constants {
		static final String modid = "bte";
		static final String modName = "Back to Eco";
		static final String version = "0.0.1";

		public static String getModid() {
			return modid;
		}

		public static String getModName() {
			return modName;
		}

		public static String getVersion() {
			return version;
		}
	}
}
