package bte.entity;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTable;

public abstract class EntityUtilMob extends EntityCreature {
	public final ResourceLocation LOOT = getLootTableLocation();

	public EntityUtilMob(World worldIn) {
		super(worldIn);
	}
	
	protected abstract ResourceLocation getLootTableLocation();

	@Override
	protected void entityInit() {
		super.entityInit();
	}
	
	@Override
	public boolean getCanSpawnHere() {
		return super.getCanSpawnHere();
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
	}
	
	@Override
	protected void initEntityAI() {
		super.initEntityAI();
	}
	

	
	@Nullable
	@Override
	protected ResourceLocation getLootTable() {
		return LOOT;
	}
	

    @Override
    public int getMaxSpawnedInChunk() {
        return super.getMaxSpawnedInChunk();
    }
    
    @Override
    protected boolean canDespawn() {
    	return false;
    }
}
