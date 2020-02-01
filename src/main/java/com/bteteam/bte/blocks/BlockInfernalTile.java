package com.bteteam.bte.blocks;

import com.bteteam.bte.blocks.tileentities.TileEntityInfernalTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.IProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockInfernalTile extends Block {

	public static IProperty<Integer> STATE;

	public BlockInfernalTile() {
		super(Properties.from(Blocks.STONE));
	}

	private static void initProperties() {
		STATE = IntegerProperty.create("state", 0, 2);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TileEntityInfernalTile();
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		initProperties();
		builder.add(STATE);
	}

	@Override
	public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity entity, Hand hand, BlockRayTraceResult result) {
		if (world.isRemote) {
			return true;
		}
		TileEntity tileEntity = world.getTileEntity(pos);
		if (tileEntity instanceof TileEntityInfernalTile.Master) {
			TileEntityInfernalTile.Master master = (TileEntityInfernalTile.Master) tileEntity;
			master.onActivated(entity);
		}
		return true;
	}

	@Override
	public void onEntityWalk(World world, BlockPos pos, Entity entity) {
		if (!world.isRemote && world.getBlockState(pos).get(STATE) == 2) {
			entity.attackEntityFrom(DamageSource.MAGIC, 4f);
			entity.setFire(5);
		}
		super.onEntityWalk(world, pos, entity);
	}

	@Override
	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldstate, boolean ismoving) {
		if (state.get(STATE) == 2) {
			AxisAlignedBB AABB = new AxisAlignedBB(pos.up(), pos.up(2));
			world.getEntitiesWithinAABB(Entity.class, AABB).forEach(e -> onEntityWalk(world, pos, e));
		}
	}

}
