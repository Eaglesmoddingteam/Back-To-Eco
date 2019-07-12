package com.bteteam.bte.proxy.server;

import com.bteteam.bte.Proxy;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;

public class Server implements Proxy {

	@Override
	public void runOnSide(Function function, Side side) {
		if(side == Side.SERVER){
			function.run();
		}
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String ID) {

	}

	@Override
	public void registerTileEntities() {

	}

	@Override
	public void preInit() {

	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

	@Override
	public void openGUI(GuiScreen screen) {

	}

	@Override
	public void registerRenders() {

	}
}
