package bte.objects.blocks;

import bte.objects.blocks.tile.TileGrowthGen;
import bte.util.helpers.MathHelper;
import btf.util.energy.IGrowthPotentialStorage;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

public class BlockGrowthGen extends BlockBase implements ITileEntityProvider{

	public BlockGrowthGen(String name, Material materialIn, CreativeTabs tab, int harvestlevel) {
		super(name, materialIn, tab, harvestlevel);
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
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileGrowthGen();
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileGrowthGen();
	}
	
	@Override
	public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
		TileEntity owned = world.getTileEntity(pos);
		if(world.getBlockState(neighbor).getBlock() != Blocks.AIR && world.getBlockState(neighbor).getBlock() instanceof ITileEntityProvider) {
		TileEntity neigbour = world.getTileEntity(neighbor);
		if(neighbor != null) {
			if(owned instanceof TileGrowthGen && neigbour instanceof IGrowthPotentialStorage) {
				TileGrowthGen TEIn = (TileGrowthGen) owned;
				TEIn.setOutput((IGrowthPotentialStorage)neigbour, MathHelper.GBFO(pos, neighbor));
			}
		}
		}
		super.onNeighborChange(world, pos, neighbor);
	}

}
