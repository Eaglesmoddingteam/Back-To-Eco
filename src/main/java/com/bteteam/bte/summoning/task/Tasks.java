package com.bteteam.bte.summoning.task;

import com.bteteam.bte.blocks.BlockInfernalTile;
import com.bteteam.bte.blocks.tileentities.TileEntityInfernalTile;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Tasks {

	public static Task toNextStage(int[] blocks, TileEntityInfernalTile.Master master, int delay) {
		return new Task() {
			@Override
			public void run() {
				BlockPos base = master.getPos();
				World world = master.getWorld();
				for (int i : blocks) {
					int x = (i % 3) - 1;
					int z = (i / 3) - 1;
					BlockPos pos = base.add(x, 0, z);
					assert world != null;
					BlockState old = world.getBlockState(pos);
					world.setBlockState(pos, old.cycle(BlockInfernalTile.STATE), 2);
					if (x == 0 && z == 0) {
						world.setTileEntity(pos, master);
					}
				}
			}

			@Override
			public int delay() {
				return delay;
			}
		};
	}

	public static Task resetStage(int[] blocks, TileEntityInfernalTile.Master master, int delay) {
		return new Task() {
			@Override
			public void run() {
				BlockPos base = master.getPos();
				World world = master.getWorld();
				for (int i : blocks) {
					int x = (i % 3) - 1;
					int z = (i / 3) - 1;
					BlockPos pos = base.add(x, 0, z);
					assert world != null;
					BlockState old = world.getBlockState(pos);
					world.setBlockState(pos, old.with(BlockInfernalTile.STATE, 0), 2);
					if (x == 0 && z == 0) {
						world.setTileEntity(pos, master);
					}
				}
			}

			@Override
			public int delay() {
				return delay;
			}
		};
	}
}
