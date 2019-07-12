package com.bteteam.bte;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;

public interface Proxy {

	void runOnSide(Function function, Side side);

	void registerItemRenderer(Item item, int meta, String ID);

	void registerTileEntities();

	void preInit();

	void init();

	void postInit();

	void openGUI(GuiScreen screen);

	void registerRenders();

	public interface Function{

		void run();

	}
}
