package com.bteteam.bte.entity.ai;

import com.bteteam.bte.blocks.Blocks;
import com.bteteam.bte.entity.InfernalBlackSmithEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;

public class FindWorkStationGoal extends Goal {

	private final InfernalBlackSmithEntity entity;

	public FindWorkStationGoal(InfernalBlackSmithEntity infernalBlackSmithEntity) {
		this.entity = infernalBlackSmithEntity;
	}

	@Override
	public boolean shouldExecute() {
		return entity.shouldCheckForStation();
	}

	@Override
	public void startExecuting() {
		if (!entity.isServerWorld()) {
			return;
		}
		BlockPos pos = entity.getPosition().add(-9, 0, -9);
		for (int x = 0; x < 18; x++) {
			for (int z = 0; z < 18; z++) {
				BlockPos scanning = pos.add(x, 0, z);
				if (!entity.world.isAirBlock(scanning)) {
					Block block = entity.world.getBlockState(scanning).getBlock();
					if (block == Blocks.infernal_forge) {
						entity.setWorkstation(scanning);
						return;
					}
				}
			}
		}
	}

}
