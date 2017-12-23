package bte.objects.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockNest extends BlockBase implements ITileEntityProvider{

	public BlockNest(String name, Material materialIn, CreativeTabs tab, int harvestlevel) {
		super(name, materialIn, tab, harvestlevel);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return null;
	}
	
	

}
