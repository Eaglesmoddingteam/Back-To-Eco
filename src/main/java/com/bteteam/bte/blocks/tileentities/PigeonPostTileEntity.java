package com.bteteam.bte.blocks.tileentities;

import com.bteteam.bte.entity.PigeonEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class PigeonPostTileEntity extends TileEntity {

	PigeonEntity pigeonEntity;

	public PigeonPostTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public boolean hasPigeon() {
		return pigeonEntity != null;
	}

	public void setPigeonSitting(PigeonEntity pigeon) {
		this.pigeonEntity = pigeon;
	}

}
