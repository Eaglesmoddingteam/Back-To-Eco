package bte.objects.blocks;

import bte.objects.blocks.tile.TileGrowthGen;
import btf.util.energy.IGrowthPotentialStorage;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockGrowthGen extends BlockBase  {

	public BlockGrowthGen(String name, Material materialIn, CreativeTabs tab, int harvestlevel) {
		super(name, materialIn, tab, harvestlevel);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean hasTileEntity() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(worldIn.getTileEntity(pos)instanceof IGrowthPotentialStorage) {
		 IGrowthPotentialStorage tile =(IGrowthPotentialStorage) worldIn.getTileEntity(pos);
		 playerIn.sendMessage(new TextComponentString("Gp stored = " + tile.getGPStored()));
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileGrowthGen();
	}

}
