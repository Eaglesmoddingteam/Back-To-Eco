package com.bteteam.bte.registries.block.obj;

import com.bteteam.bte.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

public class BlockBase extends Block {

	String name;

	public BlockBase(Material blockMaterialIn, String name) {
		super(blockMaterialIn);
		setUnlocalizedName(name);
		this.name = name;
		setRegistryName(new ResourceLocation(Main.Constants.getModid(), name));
	}

	public Item[] getItemBlocks() {
		return new Item[]{new ItemBlock(this).setRegistryName(new ResourceLocation(Main.Constants.getModid(), this.getUnlocalizedName().substring(5)))};
	}
}
