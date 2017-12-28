package bte.entity.utilitymobs.ai;

import java.util.List;

import bte.entity.EntityUtilMob;
import bte.util.entityhelper.BurnHelper;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

public class EntityAIBurn extends EntityAIBase {
	EntityCreature creatureIn;
	EntityUtilMob mobIn;
	int tick = 0;
	
	public EntityAIBurn(EntityCreature creatureIn) {
		this.creatureIn=creatureIn;
		if(creatureIn instanceof EntityUtilMob)
			mobIn = (EntityUtilMob)creatureIn;
	}
	
	@Override
	public boolean shouldExecute() {
		return true;
	}
	
	@Override
	public boolean shouldContinueExecuting() {
		return true;
	}
	
	@Override
	public void startExecuting() {
		List<EntityItem> near = creatureIn.world.getEntitiesWithinAABB(EntityItem.class, creatureIn.getEntityBoundingBox().expand(8, 3, 8));
		for (EntityItem item : near) {
			EntityItem item2 = BurnHelper.burn(item.getItem(), item.posX, item.posY, item.posZ, item.world);
			if(item2 != null) {
			item.world.spawnEntity(item2);
			if(item.world.isRemote) {
			item.world.spawnParticle(EnumParticleTypes.FLAME, true, item.posX, item.posY, item.posZ, 0.5, 0.5, 0.5);
			item.world.playSound(item.posX, item.posY, item.posZ, SoundEvents.ENTITY_BLAZE_BURN, SoundCategory.MASTER, 10f, 1f, false);
			}
			item.setDead();
			}
		}
	}
	
	@Override
	public void resetTask() {
		tick = 0;
		super.resetTask();
	}
	
	private AxisAlignedBB calcItems() {
		AxisAlignedBB aabb = new AxisAlignedBB(creatureIn.getPositionVector(), creatureIn.getLookVec());
		return aabb;
	}
	
	@Override
	public void updateTask() {
		tick++;
		if(tick >= 100) {
			resetTask();
		startExecuting();	
		}
	}

}
