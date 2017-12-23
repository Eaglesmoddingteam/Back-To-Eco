package bte.entity.utilitymobs.ai;

import java.util.List;

import bte.entity.EntityUtilMob;
import bte.util.entityhelper.BurnHelper;
import btf.main.Main;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.EnumParticleTypes;
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
		Main.LOGGER.warn("Burned Yes Baby");
		List<EntityItem> near = creatureIn.world.getEntitiesWithinAABB(EntityItem.class, creatureIn.getEntityBoundingBox().expand(4, 1, 4));
		for (EntityItem item : near) {
			EntityItem item2 = BurnHelper.burn(item.getItem(), item.posX, item.posY, item.posZ, item.world);
			if(item2 != null) {
			item.world.spawnEntity(item2);
			item.world.spawnParticle(EnumParticleTypes.FLAME, creatureIn.posX, creatureIn.posY, creatureIn.posZ, 1, 1, 1);
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
