package com.bteteam.bte.registries.block;

import com.bteteam.bte.registries.Registry;
import com.bteteam.bte.registries.block.obj.BlockBase;
import com.bteteam.bte.registries.block.obj.PlantBase;
import net.minecraft.block.Block;
import net.minecraft.util.math.AxisAlignedBB;

public class Blocks implements Registry<Block> {

	@Override
	public Class<? extends Block> getType() {
		return BlockBase.class;
	}

	public static AxisAlignedBB PLANTS_HITBOX = new AxisAlignedBB(0, 0, 0, 1, 0.8, 1);

	public static BlockBase agawa = PlantBase.withAABB(PLANTS_HITBOX, "agawa");

	public static BlockBase aqumius = PlantBase.withAABB(PLANTS_HITBOX, "aqumius");

	public static BlockBase araucaria = PlantBase.withAABB(PLANTS_HITBOX, "araucaria");

	public static BlockBase small_cactus = new PlantBase("small_cactus");

	public static BlockBase coral = new PlantBase("coral");

	public static BlockBase curcuma = PlantBase.withAABB(PLANTS_HITBOX, "curcuma");

	public static BlockBase dragon_lily = PlantBase.withAABB(PLANTS_HITBOX, "dragon_lily");

	public static BlockBase ender_bloom = PlantBase.withAABB(PLANTS_HITBOX, "ender_bloom");

	public static BlockBase ender_rose = PlantBase.withAABB(PLANTS_HITBOX, "ender_rose");

	public static BlockBase endregor_mudroot = PlantBase.withAABB(PLANTS_HITBOX, "endregor_mudroot");

	public static BlockBase flycatcher = new PlantBase("flycatcher");

	public static BlockBase horsetail_plant = new PlantBase("horsetail_plant");

	public static BlockBase lovage = new PlantBase("lovage");

	public static BlockBase phoenix_flower = PlantBase.withAABB(PLANTS_HITBOX, "phoenix_flower");

	public static BlockBase pineapple = PlantBase.withAABB(PLANTS_HITBOX, "pineapple");

	public static BlockBase seaweed = PlantBase.withAABB(PLANTS_HITBOX, "seaweed");

	public static BlockBase shamrock = new PlantBase("shamrock");

	public static BlockBase tea_plant = PlantBase.withAABB(PLANTS_HITBOX, "tea_plant");

}