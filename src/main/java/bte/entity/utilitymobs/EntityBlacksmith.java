package bte.entity.utilitymobs;

import bte.entity.EntityUtilMob;
import bte.entity.utilitymobs.ai.EntityAIBurn;
import bte.entity.utilitymobs.ai.EntityAiMoveToNest;
import bte.util.entityhelper.BurnHelper;
import bte.util.helpers.StringHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
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
		food=20;
	}

	public EntityBlacksmith(World worldIn) {
		super(worldIn);
		setSize(0.95F, 1.6F);
		this.stepHeight = 1.0F;
		food=20;
	}

	@Override
	protected ResourceLocation getLootTableLocation() {
		return StringHelper.GR("loot/infernalblacksmith");
	}
	
	@Override
	protected void initEntityAI() {
		tasks.addTask(8, new EntityAiMoveToNest(homeNest, this));
		tasks.addTask(7, new EntityAIWanderAvoidWater(this, 0.7));
		tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
		tasks.addTask(8, new EntityAILookIdle(this));
		tasks.addTask(9, new EntityAIBurn(this));
		applyEntityAI();
		super.initEntityAI();
	}

	protected void applyEntityAI(){
		
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0F);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if(entityIn instanceof EntityItem) {
			EntityItem itemEntity = (EntityItem) entityIn;
			burn(itemEntity.getItem(), entityIn.posX, entityIn.posY, entityIn.posZ);
			entityIn.setDead();
			return true;
		}
		return false;
	}
	
	private void burn(ItemStack stack, double x, double y, double z) {
		world.spawnEntity(BurnHelper.burn(stack, x, y, z, world));
		world.spawnParticle(EnumParticleTypes.FLAME, posX, posY+1, posZ, posX - x, posY - y, posZ - z, 10);
	}
}
