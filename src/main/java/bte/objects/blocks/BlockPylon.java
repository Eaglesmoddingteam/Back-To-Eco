package bte.objects.blocks;

import bte.objects.blocks.tile.TilePylon;
import bte.util.GrPUtil.GrPConductHelper.PylonTypes;
import btf.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockPylon extends BlockBase implements ITileEntityProvider{
	PylonTypes typeIn;

	public BlockPylon(String name, Material materialIn, CreativeTabs tab, int harvestlevel, PylonTypes typeIn) {
		super(name, materialIn, tab, harvestlevel);
		this.typeIn=typeIn;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TilePylon(typeIn);
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TilePylon(typeIn);
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		switch(typeIn) {
		case CELESTIAL:
		case NAZZU:
		case TERRALIC:
			TilePylon tile = (TilePylon) worldIn.getTileEntity(pos);
			break;
		default:
			break;	
		}
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack stack = playerIn.getActiveItemStack();
		if(stack.getItem() == ItemInit.block_uniter) {
		if(!stack.hasTagCompound()) {
			stack.setTagCompound(new NBTTagCompound());
		} 
		NBTTagCompound compound = stack.getTagCompound();
		if(!compound.hasKey("x")) {
			compound.setInteger("x", pos.getX());
			compound.setInteger("y", pos.getY());
			compound.setInteger("z", pos.getZ());
		} else {
			int x = compound.getInteger("x");
			int y = compound.getInteger("y");
			int z = compound.getInteger("z");
			BlockPos saved = new BlockPos(x, y, z);
			if(worldIn.getTileEntity(saved) instanceof TilePylon) {
			TilePylon tileEntitySaved = (TilePylon) worldIn.getTileEntity(saved);
			TilePylon tileIn = (TilePylon) worldIn.getTileEntity(pos);
			tileEntitySaved.connect(tileIn, playerIn);
			compound.removeTag("x");
			compound.removeTag("y");
			compound.removeTag("z");
			}
		}
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}


}
