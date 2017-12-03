package bte.objects.blocks;

import bte.objects.blocks.tile.TileHive;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBeeHive extends BlockBase{

	public BlockBeeHive(String name, Material materialIn, CreativeTabs tab) {
		super(name, materialIn, tab, 1);
	}
	
	@Override
	public boolean hasTileEntity() {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileHive();
	}

}
