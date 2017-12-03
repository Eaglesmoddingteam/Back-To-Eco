package bte.objects.blocks;

import bte.main.Main;
import bte.objects.blocks.tile.TileHive;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBeeHive extends BlockBase{
	public static final int GUI_ID = 1;

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
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// Only execute on the server
        if (worldIn.isRemote) {
            return true;
        }
        TileEntity te = worldIn.getTileEntity(pos);
        if (!(te instanceof TileHive)) {
            return false;
        }
        playerIn.openGui(Main.instance, GUI_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
	}

}
