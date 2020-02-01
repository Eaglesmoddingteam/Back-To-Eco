package com.bteteam.bte.summoning.recipe;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

public interface EntitySupplier<T extends LivingEntity> {

	T supply(World world);

}
