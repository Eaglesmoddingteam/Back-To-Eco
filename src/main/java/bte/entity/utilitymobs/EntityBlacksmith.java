package bte.entity.utilitymobs;

import bte.entity.EntityUtilMob;
import bte.entity.utilitymobs.ai.EntityAiMoveToNest;
import bte.util.helpers.StringHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIMoveToBlock;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityBlacksmith extends EntityUtilMob {
	BlockPos homeNest;
	
	public EntityBlacksmith(World worldIn, BlockPos nest) {
		super(worldIn);
		homeNest=nest;
	}

	public EntityBlacksmith(World worldIn) {
		super(worldIn);
	}

	@Override
	protected ResourceLocation getLootTableLocation() {
		return StringHelper.GR("loot/infernalblacksmith");
	}
	
	@Override
	protected void initEntityAI() {
		tasks.addTask(1, new EntityAiMoveToNest(homeNest, this));
		tasks.addTask(2, new EntityAIMoveTowardsRestriction(this, 2));
		
		applyEntityAI();
		super.initEntityAI();
	}
	
	@Override
	protected void applyEntityAI(){
		
	}

}
