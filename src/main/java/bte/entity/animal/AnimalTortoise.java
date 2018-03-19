package bte.entity.animal;

import bte.entity.EntityBteAnimal;
import bte.entity.animal.ai.AnimalAIWalk;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.init.Biomes;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class AnimalTortoise extends EntityBteAnimal<AnimalTortoise> {

	public AnimalTortoise(World worldIn) {
		this(worldIn, Biomes.BEACH, Biomes.DESERT, Biomes.OCEAN);
	}

	public AnimalTortoise(World worldIn, Biome... biomes) {
		super(worldIn, biomes);
		this.setSize(0.7f, 0.8f);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
	}

	@Override
	public boolean canBeRidden() {
		return false;
	}

	@Override
	public void update() {

	}

	@Override
	public AnimalTortoise getChild() {
		AnimalTortoise child = new AnimalTortoise(this.world, (Biome[]) this.BIOMESIN.toArray());
		child.setGrowingAge(-200);
		return child;
	}

	@Override
	public boolean canLove() {
		return false;
	}

	@Override
	public void initAI() {
		this.tasks.addTask(9, new EntityAIWanderAvoidWater(this, 0.5f));
	}
	
}
