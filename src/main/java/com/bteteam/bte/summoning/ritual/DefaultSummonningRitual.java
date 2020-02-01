package com.bteteam.bte.summoning.ritual;

import com.bteteam.bte.blocks.tileentities.TileEntityInfernalTile;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3i;

public class DefaultSummonningRitual<T extends LivingEntity> extends AbstractSummoningRitual {

	T entity;

	public DefaultSummonningRitual(TileEntityInfernalTile.Master masterTile, T toSpawn) {
		super(masterTile);
		this.entity = toSpawn;
	}

	@Override
	protected void spawnEntity() {
		Vec3i vec3i = masterTile.getPos().add(0, 2, 0);
		entity.setPosition(vec3i.getX() + 0.5, vec3i.getY() + 0.5, vec3i.getZ() + 0.5);
		masterTile.getWorld().addEntity(entity);
	}

	@Override
	protected int getStages() {
		return 6;
	}

	@Override
	protected float getSpeed(int stage) {
		return stage * 0.33f + 1f;
	}

	@Override
	protected int getDifficulty(int stage, int turn) {
		return Math.max(Math.min(8, stage * 2), 1);
	}

	@Override
	protected int getTurns(int stage) {
		return 12;
	}

}
