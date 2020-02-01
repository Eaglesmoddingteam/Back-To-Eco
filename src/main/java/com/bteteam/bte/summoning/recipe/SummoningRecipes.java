package com.bteteam.bte.summoning.recipe;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.Items;

public class SummoningRecipes {

	public static SummoningRecipe summon_chicken = new SummoningRecipe(world -> new ChickenEntity(EntityType.CHICKEN, world), Items.FEATHER, Items.WHEAT_SEEDS);

}
