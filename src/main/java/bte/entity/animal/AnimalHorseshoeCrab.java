package bte.entity.animal;

import bte.entity.EntityBteAnimal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.init.Biomes;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class AnimalHorseshoeCrab extends EntityBteAnimal<AnimalHorseshoeCrab> {

	public AnimalHorseshoeCrab(World worldIn) {
		this(worldIn, Biomes.SWAMPLAND, Biomes.BEACH);
	}
	
	public AnimalHorseshoeCrab(World worldIn, Biome... biomes) {
		super(worldIn, biomes);
		this.setSize(0.8f, 0.4f);
		this.stepHeight = 3.1f;
	}

	@Override
	public boolean canBeRidden() {
		return false;
	}

	@Override
	public void update() {
		
	}

	@Override
	public AnimalHorseshoeCrab getChild() {
		AnimalHorseshoeCrab a = new AnimalHorseshoeCrab(world);
		a.posX = this.posX;
		a.posY = this.posY;
		a.posZ = this.posZ;
		a.setGrowingAge(-200);
		return a;
	}

	@Override
	public boolean canLove() {
		return false;
	}

	@Override
	public void initAI() {
		this.tasks.addTask(9, new EntityAIWander(this, 0.5f));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
	}
	
	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}
	
	@Override
	protected float getWaterSlowDown() {
		return 0f;
	}
	
	@Override
	public boolean isPushedByWater() {
		return false;
	}

}
