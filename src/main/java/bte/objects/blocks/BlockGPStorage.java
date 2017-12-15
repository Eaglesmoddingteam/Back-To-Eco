package bte.objects.blocks;

import bte.objects.blocks.tile.TileGpStorage;
import bte.util.helpers.MathHelper;
import btf.util.energy.IGrowthPotentialStorage;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGPStorage extends BlockBase implements ITileEntityProvider{

	public BlockGPStorage(String name, Material materialIn, CreativeTabs tab, int harvestlevel) {
		super(name, materialIn, tab, harvestlevel);
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileGpStorage();
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileGpStorage();
	}
	
	@Override
	public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
		TileEntity neighbour = world.getTileEntity(neighbor);
		if(neighbour != null) {
			if(neighbour instanceof IGrowthPotentialStorage && neighbor.getY()==pos.getY()) {
				TileGpStorage ownTE = (TileGpStorage) world.getTileEntity(pos);
				ownTE.addOutput((IGrowthPotentialStorage) neighbour, MathHelper.GBFO(pos, neighbor));
			}
		}
		super.onNeighborChange(world, pos, neighbor);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(worldIn.getTileEntity(pos) instanceof IGrowthPotentialStorage) {
			 IGrowthPotentialStorage tile =(IGrowthPotentialStorage) worldIn.getTileEntity(pos);
			 playerIn.sendStatusMessage(new TextComponentString("Gp stored = " + tile.getGPStored()), true);
			}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		BlockPos under = new BlockPos(pos.getX(), pos.getY()-1, pos.getZ());
		worldIn.getBlockState(under).getBlock().onNeighborChange(worldIn, under, pos);
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}

}
