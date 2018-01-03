package bte.objects.blocks;

import bte.objects.blocks.tile.TileGrowthGen;
import bte.util.helpers.MathHelper;
import btf.util.energy.CapabilityGrowthPotential;
import btf.util.energy.IGrowthPotentialStorage;
import net.minecraft.block.Block;
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
	MathHelper mh = MathHelper.INSTANCE;
	
	public BlockGrowthGen(String name, Material materialIn, CreativeTabs tab, int harvestlevel) {
		super(name, materialIn, tab, harvestlevel);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		TileGrowthGen tile = (TileGrowthGen) worldIn.getTileEntity(pos);
		playerIn.sendStatusMessage(new TextComponentString("You have "+ tile.GPIn() + " GrP stored"), true);
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if(worldIn.getBlockState(fromPos).getBlock().hasTileEntity(worldIn.getBlockState(fromPos))) {
			TileEntity TE = worldIn.getTileEntity(fromPos);
			if(TE.hasCapability(CapabilityGrowthPotential.GROWTHPOTENTIAL, null)) {
				TileGrowthGen owned = (TileGrowthGen) worldIn.getTileEntity(pos);
				owned.setOutput(TE, mh.GBFO(pos, fromPos));
			}
		}
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
	}
	
	@Override
	public boolean hasTileEntity() {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileGrowthGen();
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileGrowthGen();
	}

}
