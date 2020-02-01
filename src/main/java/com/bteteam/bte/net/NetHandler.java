package com.bteteam.bte.net;

import com.bteteam.bte.Main;
import com.bteteam.bte.net.packet.PacketUpdateTE;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetHandler {

	private static final String PROTOCOL_VERSION = "1.0";
	public static final SimpleChannel MAIN = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(Main.MODID, "main"),
			() -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals
	);
	public static final SimpleChannel UPDATE = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(Main.MODID, "update"),
			() -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals
	);

	public static void init() {
		UPDATE.registerMessage(0, PacketUpdateTE.class, PacketUpdateTE::encrypt, PacketUpdateTE::decrypt, PacketUpdateTE::handle);
	}

}
