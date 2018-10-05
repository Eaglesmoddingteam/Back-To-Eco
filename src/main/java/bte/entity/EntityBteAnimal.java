package bte.entity;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public abstract class EntityBteAnimal<T extends EntityAgeable> extends EntityAnimal {
	public final ArrayList<Biome> BIOMESIN;

	public EntityBteAnimal(World worldIn, Biome... biomes) {
		super(worldIn);
		BIOMESIN = new ArrayList<>();
		for (Biome b : biomes) {
			BIOMESIN.add(b);
		}
	}
	
	public abstract boolean canBeRidden();

	@Override
	public void onLivingUpdate() {
		update();
		if (!canLove())
			resetInLove();
		super.onLivingUpdate();
	}

	public abstract void update();

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return (EntityAgeable) getChild();
	}

	public boolean canLiveInBiome(Biome biome) {
		return BIOMESIN.contains(biome);
	}

	public abstract T getChild();

	@Override
	protected void addPassenger(Entity passenger) {
		if (canBeRidden())
			super.addPassenger(passenger);
	}

	public abstract boolean canLove();

	@Override
	public boolean isInLove() {
		return canLove() ? super.isInLove() : false;
	}

	@Override
	protected void initEntityAI() {
		initAI();
		super.initEntityAI();
	}

	public abstract void initAI();
}
