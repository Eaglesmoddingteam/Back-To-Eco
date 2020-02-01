package com.bteteam.bte.blocks.tileentities;

import com.bteteam.bte.blocks.Blocks;
import net.minecraft.tileentity.TileEntityType;

@SuppressWarnings("visibility")
public class TileEntityTypes {

	private TileEntityTypes(){}

	public static final TileEntityType infernaltile = TileEntityType.Builder.create(TileEntityInfernalTile::new, Blocks.infernal_tile).build(null);
	public static final TileEntityType infernaltilemaster = TileEntityType.Builder.create(TileEntityInfernalTile.Master::new, Blocks.infernal_tile).build(null);
	public static final TileEntityType infernalforge = TileEntityType.Builder.create(TileEntityInfernalForge::new, Blocks.infernal_forge).build(null);

}
