package com.bteteam.bte.entity;

import com.bteteam.bte.entity.ai.BurnItemGoal;
import com.bteteam.bte.entity.ai.FindWorkStationGoal;
import com.google.common.collect.Lists;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class InfernalBlackSmithEntity extends CreatureEntity {

	private static final Random random = new Random();
	HandSide handSide;
	private BlockPos workstation = null;
	private Vec3d lastCheckedPos = new Vec3d(0, 0, 0);

	protected InfernalBlackSmithEntity(EntityType entityType, World p_i48577_2_) {
		super(entityType, p_i48577_2_);
		handSide = HandSide.values()[random.nextInt(2)];
	}

	public boolean shouldCheckForStation() {
		return !hasWorkStation() && this.lastCheckedPos.distanceTo(this.getPositionVec()) > 9;
	}

	public boolean hasWorkStation() {
		return workstation != null;
	}

	public BlockPos getWorkstation() {
		return workstation;
	}

	public void setWorkstation(BlockPos workstation) {
		this.workstation = workstation;
		System.out.println("found workstation");//todo remove
	}

	@Override
	public HandSide getPrimaryHand() {
		return handSide;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 0.3f, 0.3F) {
			@Nullable
			@Override
			protected Vec3d getPosition() {
				if (this.creature.isInWaterOrBubbleColumn()) {
					Vec3d vec3d = RandomPositionGenerator.getLandPos(this.creature, 15, 7);
					return vec3d == null ? new Vec3d(workstation.up()) : vec3d;
				} else {
					return this.creature.getRNG().nextFloat() >= this.probability ? RandomPositionGenerator.getLandPos(this.creature, 10, 7) : new Vec3d(workstation.up());
				}
			}
		});
		this.goalSelector.addGoal(5, new FindWorkStationGoal(this));
		this.goalSelector.addGoal(5, new BurnItemGoal(this));
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		if (hasWorkStation()) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putInt("x", workstation.getX());
			nbt.putInt("y", workstation.getY());
			nbt.putInt("z", workstation.getZ());
			compound.put("workstation", nbt);
		}
		super.writeAdditional(compound);
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		CompoundNBT nbt = (CompoundNBT) compound.get("workstation");
		if (nbt != null) {
			workstation = new BlockPos(nbt.getInt("x"), nbt.getInt("y"), nbt.getInt("z"));
		}
		super.readAdditional(compound);
	}
}
