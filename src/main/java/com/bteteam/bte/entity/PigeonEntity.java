package com.bteteam.bte.entity;

import com.bteteam.bte.blocks.PigeonPostBlock;
import com.bteteam.bte.world.PigeonPosts;
import com.sun.istack.internal.NotNull;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Optional;

public class PigeonEntity extends CreatureEntity {

	@OnlyIn(Dist.CLIENT)
	private final Client clientDataObject = new Client();
	int pendingticks = 0;
	private StateInstace state = new StateInstace(STATE.PENDING);
	private PigeonPosts pigeonPosts;

	protected PigeonEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public boolean hasNoGravity() {
		return true;
	}

	@OnlyIn(Dist.CLIENT)
	public Client getClientDataObject() {
		return clientDataObject;
	}

	public StateInstace getState() {
		return state;
	}

	@Override
	public void tick() {
		super.tick();
		logicTick();
	}

	@Override
	protected void registerGoals() {
		goalSelector.addGoal(1, new LookRandomlyGoal(this));
	}


	private void logicTick() {
		if (world.isRemote) {
			return;
		}
		switch (state.getState()) {
			case SITTING:
				break;
			case PENDING:
				if (pigeonPosts == null) {
					pigeonPosts = PigeonPosts.get(world.getServer().getWorld(world.getDimension().getType()));
				}

				Optional<BlockPos> closestPostTo = pigeonPosts.getClosestPostTo(this, 20);
				if (closestPostTo.isPresent()) {
					pendingticks = 0;
					state = new StateInstace(STATE.FLYING);
					state.set(closestPostTo.get());
					Vec3i vec3i = closestPostTo.get();
					moveController.setMoveTo(vec3i.getX() + 0.5, vec3i.getY() + 1.1, vec3i.getZ() + 0.5, 0.7);
				}

				if (++pendingticks > 100) {
					pendingticks = 0;
					state = new StateInstace(STATE.FOLLOWING);
					PlayerEntity playerEntity = world.getClosestPlayer(this, 20);
					if (playerEntity != null) {
						state.set(playerEntity);
					}
				}

				if (!moveController.isUpdating()) {
					Vec3d vec3d = RandomPositionGenerator.getLandPos(this, 20, 5);
					moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 0.7);
				}
				break;
			case FLYING:
				if (!moveController.isUpdating()) {
					if (achievedGoal()) {
						BlockPos pos = state.blockPos.get();
						boolean flag = world.getBlockState(pos).getBlock() instanceof PigeonPostBlock;

					}
				}
				break;
			case FOLLOWING:
				if (!moveController.isUpdating())
					break;
				PlayerEntity following = state.getPlayerEntity();
				moveController.setMoveTo(following.posX, following.posY + 0.5, following.posZ, 0.7);
		}
	}

	private boolean achievedGoal() {
		BlockPos pos = state.blockPos.get();
		boolean flag = world.getBlockState(pos).getBlock() instanceof PigeonPostBlock;
		Vec3d dest = new Vec3d(pos.getX() + 0.5, pos.getY() + 1.1, pos.getZ() + 0.5);
		Vec3d block = new Vec3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
		return block.distanceTo(this.getPositionVec()) < 2 && (!flag || dest.distanceTo(dest) < 1);
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.put("state", state.serializeNBT());
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		state = StateInstace.deserializeNBT((CompoundNBT) compound.get("state"), world);
	}

	public enum STATE {
		PENDING, FOLLOWING, SITTING, FLYING
	}

	@OnlyIn(Dist.CLIENT)
	public static class Client {
		//for animation data

	}

	public static class StateInstace {

		private final STATE state;
		Optional<PlayerEntity> playerEntity = Optional.empty();
		Optional<BlockPos> blockPos = Optional.empty();

		public StateInstace(STATE state) {
			this.state = state;
		}

		public static StateInstace deserializeNBT(CompoundNBT nbt, World world) {
			STATE state = STATE.values()[nbt.getInt("state")];
			StateInstace instace = new StateInstace(state);
			if (nbt.contains("player")) {
				instace.set(world.getPlayerByUuid(nbt.getUniqueId("player")));
			}
			if (nbt.contains("pos")) {
				instace.set(NBTUtil.readBlockPos((CompoundNBT) nbt.get("pos")));
			}
			return instace;
		}

		protected void set(@NotNull PlayerEntity entity) {
			this.playerEntity = Optional.of(entity);
		}

		protected void set(@NotNull BlockPos pos) {
			this.blockPos = Optional.of(pos);
		}

		@Nullable
		public PlayerEntity getPlayerEntity() {
			return playerEntity.orElse(null);
		}

		@Nullable
		public BlockPos getBlockPos() {
			return blockPos.orElse(null);
		}

		public STATE getState() {
			return state;
		}

		public CompoundNBT serializeNBT() {
			CompoundNBT compoundNBT = new CompoundNBT();
			compoundNBT.putInt("state", state.ordinal());
			playerEntity.ifPresent(entity -> compoundNBT.putUniqueId("player", entity.getUniqueID()));
			blockPos.ifPresent(pos -> compoundNBT.put("pos", NBTUtil.writeBlockPos(pos)));
			return compoundNBT;
		}
	}
}
