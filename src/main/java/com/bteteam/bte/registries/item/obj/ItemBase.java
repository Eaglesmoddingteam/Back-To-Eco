package com.bteteam.bte.registries.item.obj;

import com.bteteam.bte.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemBase extends Item {

	public ItemBase(String name) {
		super();
		setMaxStackSize(64);
		setUnlocalizedName(name);
		setRegistryName(new ResourceLocation(Main.Constants.getModid(), name));
	}

	public ItemBase(String name, CreativeTabs creativeTab){
		this(name);
		this.setCreativeTab(creativeTab);
	}

}
