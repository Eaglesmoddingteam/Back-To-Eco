package com.bteteam.bte.registries.block.obj;

import com.bteteam.bte.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

public class BlockBase extends Block {

	public BlockBase(Material blockMaterialIn, MapColor blockMapColorIn, String name) {
		super(blockMaterialIn, blockMapColorIn);
		setUnlocalizedName(name);
		setRegistryName(new ResourceLocation(Main.Constants.getModid(), name));
	}

	public Item[] getItemBlocks(){
		return new ItemBlock[]{new ItemBlock(this)};
	}
}
