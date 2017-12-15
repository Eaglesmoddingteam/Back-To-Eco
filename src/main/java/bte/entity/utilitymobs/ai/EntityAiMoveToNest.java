package bte.entity.utilitymobs.ai;

import bte.util.helpers.MathHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;

public class EntityAiMoveToNest extends EntityAIBase {
	BlockPos homeNest;
	EntityCreature creatureIn;
	
	public EntityAiMoveToNest(BlockPos homeNest, EntityCreature creature) {
	this.homeNest = homeNest;
	creatureIn = creature;
	}

	@Override
	public boolean shouldExecute() {
		if (homeNest!=null) {
		BlockPos EntityPos = creatureIn.getPosition();
		int x = homeNest.getX();
		int y = homeNest.getY();
		int z = homeNest.getZ();
		if(MathHelper.GPUI(x - EntityPos.getX(), y - EntityPos.getY(), z - EntityPos.getZ()) > 30)
			return true;
		}
		return false;
	}
	
	
	@Override
	public void startExecuting() {
		int x = homeNest.getX();
		int y = homeNest.getY();
		int z = homeNest.getZ();
		creatureIn.getNavigator().tryMoveToXYZ(x, y, z, 2);
	}

}
