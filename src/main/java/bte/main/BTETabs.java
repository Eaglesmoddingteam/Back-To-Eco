package bte.main;

import bte.init.ItemInit;
import bte.util.helpers.MathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BTETabs {
public static final BTETabs INSTANCE = new BTETabs();
public static CreativeTabs bugstab = new CreativeTabs("bugstab") {
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.picker_ant);
	}
};
}
