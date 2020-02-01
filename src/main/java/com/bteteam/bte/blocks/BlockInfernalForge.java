package com.bteteam.bte.blocks;

import com.bteteam.bte.blocks.tileentities.TileEntityInfernalForge;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IEnviromentBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class BlockInfernalForge extends Block {

	public BlockInfernalForge() {
		super(Properties.from(Blocks.ANVIL));
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TileEntityInfernalForge();
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public boolean doesSideBlockRendering(BlockState state, IEnviromentBlockReader world, BlockPos pos, Direction face) {
		return true;
	}

	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (worldIn.isRemote) {
			return true;
		}
		ItemStack heldItem = player.getHeldItem(handIn);
		ItemStackHandler itemStackHandler = ((TileEntityInfernalForge) worldIn.getTileEntity(pos)).getStackHandler();
		if (!heldItem.isEmpty()) {
			player.setHeldItem(handIn, itemStackHandler.insertItem(0, heldItem, false));
		} else {
			player.setHeldItem(handIn, itemStackHandler.extractItem(0, 1, false));
		}
		worldIn.getTileEntity(pos).markDirty();
		return true;
	}
}
