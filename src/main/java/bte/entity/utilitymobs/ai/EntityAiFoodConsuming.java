package bte.entity.utilitymobs.ai;

import bte.entity.EntityUtilMob;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.Item;

public class EntityAiFoodConsuming extends EntityAIBase{
	Item food;
	EntityCreature creatureIn;
	boolean isCorrect = false;
	EntityUtilMob utilMobIn;
	
	public EntityAiFoodConsuming(EntityCreature creature, Item food) {
		if(creature instanceof EntityUtilMob)
			isCorrect = true;
		creatureIn = creature;
		this.food=food;
		cast();
	}

	void cast() {
	if(isCorrect) {
		utilMobIn = (EntityUtilMob) creatureIn;
	}
	}
	
	
	@Override
	public boolean shouldExecute() {
		if(utilMobIn.getFood() < 20)
			return true;
		return false;
	}

}
