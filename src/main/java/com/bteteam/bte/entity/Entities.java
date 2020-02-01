package com.bteteam.bte.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

public class Entities {

	public static EntityType<InfernalBlackSmithEntity> infernal_blacksmith = EntityType.Builder.create(InfernalBlackSmithEntity::new, EntityClassification.MISC).immuneToFire().size(0.95F, 1.6F).build("backtoeco:infernal_blacksmith");
	public static EntityType<PigeonEntity> pigeon = EntityType.Builder.create(PigeonEntity::new, EntityClassification.MISC).immuneToFire().size(0.5F, 0.5F).build("backtoeco:pigeon");

}
