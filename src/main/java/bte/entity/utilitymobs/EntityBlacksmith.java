package bte.entity.utilitymobs;

import bte.entity.EntityUtilMob;
import bte.entity.utilitymobs.ai.EntityAiMoveToNest;
import bte.util.helpers.StringHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityBlacksmith extends EntityUtilMob {
	public int FoodIn;
	BlockPos homeNest;
	
	public EntityBlacksmith(World worldIn, BlockPos nest) {
		super(worldIn);
		homeNest=nest;
		setSize(0.95F, 1.6F);
		this.stepHeight = 1.0F;
	}

	public EntityBlacksmith(World worldIn) {
		super(worldIn);
		setSize(0.95F, 1.6F);
		this.stepHeight = 1.0F;
	}

	@Override
	protected ResourceLocation getLootTableLocation() {
		return StringHelper.GR("loot/infernalblacksmith");
	}
	
	@Override
	protected void initEntityAI() {
		tasks.addTask(1, new EntityAiMoveToNest(homeNest, this));
		tasks.addTask(7, new EntityAIWanderAvoidWater(this, 0.7D));
		tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
		tasks.addTask(8, new EntityAILookIdle(this));
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
