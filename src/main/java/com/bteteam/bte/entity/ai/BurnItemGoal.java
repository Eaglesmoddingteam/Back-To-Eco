package com.bteteam.bte.entity.ai;

import com.bteteam.bte.blocks.tileentities.TileEntityInfernalForge;
import com.bteteam.bte.entity.InfernalBlackSmithEntity;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.util.math.Vec3d;

public class BurnItemGoal extends Goal {
	private final InfernalBlackSmithEntity entity;

	public BurnItemGoal(InfernalBlackSmithEntity entity) {
		this.entity = entity;
	}

	@Override
	public boolean shouldExecute() {
		return entity.hasWorkStation() && entity.getPositionVector().distanceTo(new Vec3d(entity.getWorkstation())) < 3;
	}

	@Override
	public void startExecuting() {
		TileEntityInfernalForge tileEntityInfernalForge = (TileEntityInfernalForge) entity.world.getTileEntity(entity.getWorkstation());
		if (tileEntityInfernalForge != null && tileEntityInfernalForge.canSmelt()) {
			AbstractCookingRecipe abstractCookingRecipe = tileEntityInfernalForge.getRecipe().get();
			tileEntityInfernalForge.getStackHandler().setStackInSlot(0, abstractCookingRecipe.getRecipeOutput().copy());

			entity.lookAt(EntityAnchorArgument.Type.EYES, new Vec3d(entity.getWorkstation()).add( 0.5, 0.5, 0.5));
		}
		//todo: particle
	}
}
