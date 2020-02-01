package com.bteteam.bte.entity.ai;

import com.bteteam.bte.blocks.Blocks;
import com.bteteam.bte.entity.InfernalBlackSmithEntity;
import net.minecraft.entity.ai.goal.Goal;

public class CheckWorkStationGoal extends Goal {

	private final InfernalBlackSmithEntity entity;

	public CheckWorkStationGoal(InfernalBlackSmithEntity entity) {
		this.entity = entity;
	}

	@Override
	public boolean shouldExecute() {
		return entity.hasWorkStation();
	}

	@Override
	public void startExecuting() {
		boolean flag = entity.world.getBlockState(entity.getWorkstation()).getBlock() == Blocks.infernal_forge;
		if(!flag){
			entity.setWorkstation(null);
		}
	}
}
