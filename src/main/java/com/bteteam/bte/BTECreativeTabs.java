package com.bteteam.bte;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class BTECreativeTabs {

	public static final CreativeTabs BUGS = new CreativeTabs("bugstab") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Main.ITEMS_REGISTRY.beatle);
		}
	};
	public static final CreativeTabs BLOCKS = new CreativeTabs("blockstab") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.COMMAND_BLOCK_MINECART);//TODO
		}
	};
}
