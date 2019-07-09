package com.bteteam.bte.registries.block;

import com.bteteam.bte.registries.Registry;
import com.bteteam.bte.registries.block.obj.BlockBase;
import net.minecraft.block.Block;

public class Blocks implements Registry<Block> {

	@Override
	public Class<? extends Block> getType() {
		return BlockBase.class;
	}

}