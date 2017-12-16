package bte.entity.utilitymobs;

import bte.entity.EntityUtilMob;
import bte.entity.utilitymobs.ai.EntityAiMoveToNest;
import bte.util.helpers.StringHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveToBlock;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityBlacksmith extends EntityUtilMob {
	BlockPos homeNest;
	
	public EntityBlacksmith(World worldIn, BlockPos nest) {
		super(worldIn);
		homeNest=nest;
		setSize(1.5F, 1.0F);
		this.stepHeight = 1.0F;
	}

	public EntityBlacksmith(World worldIn) {
		super(worldIn);
		setSize(1.5F, 1.0F);
		this.stepHeight = 1.0F;
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

	protected void applyEntityAI(){
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0F);
	}
}
