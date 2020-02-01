package com.bteteam.bte.world;

import com.bteteam.bte.Main;
import com.bteteam.bte.blocks.PigeonPostBlock;
import com.bteteam.bte.blocks.tileentities.PigeonPostTileEntity;
import com.bteteam.bte.entity.PigeonEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldSavedData;

import java.util.*;

public class PigeonPosts extends WorldSavedData {

	public static final String name = Main.MODID + ":pigeonposts";
	private static final Map<Integer, PigeonPosts> instances = new HashMap<>();
	private final World world;
	private final List<BlockPos> posts = new ArrayList<>();

	public PigeonPosts(World world) {
		super(name);
		this.world = world;
		instances.put(world.dimension.getType().getId(), this);
	}

	public static PigeonPosts get(ServerWorld world) {
		return world.getSavedData().getOrCreate(() -> new PigeonPosts(world), name);
	}

	@Override
	public void read(CompoundNBT nbt) {
		for (int i = 0; i < nbt.getInt("count"); i++) {
			StringBuilder builder = new StringBuilder();
			builder.append('_').append(i);
			posts.add(i, NBTUtil.readBlockPos((CompoundNBT) nbt.get(builder.toString())));
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.putInt("count", posts.size());
		for (int i = 0; i < posts.size(); i++) {
			StringBuilder builder = new StringBuilder();
			builder.append('_').append(i);
			compound.put(builder.toString(), NBTUtil.writeBlockPos(posts.get(i)));
		}
		return compound;
	}

	public Optional<BlockPos> getClosestPostTo(PigeonEntity entity, double range) {
		boolean checkdistance = range >= 0;
		TreeMap<Double, BlockPos> posMap = new TreeMap<>();
		posts.stream().filter(pos -> ((PigeonPostTileEntity) world.getTileEntity(pos)).hasPigeon()).forEach(blockPos -> posMap.put(entity.getDistanceSq(blockPos.getX(), blockPos.getY(), blockPos.getZ()), blockPos));
		BlockPos pos = null;
		if (posMap.size() > 0) {
			if (!checkdistance || range >= posMap.lastKey())
				pos = posMap.lastEntry().getValue();
		}
		return Optional.ofNullable(pos);
	}

	public boolean addPost(BlockPos pos) {
		boolean flag = world.getBlockState(pos).getBlock() instanceof PigeonPostBlock;
		if (flag) {
			posts.add(pos);
			markDirty();
		}
		return flag;
	}

	public boolean removePost(BlockPos pos) {
		boolean flag = !(world.getBlockState(pos).getBlock() instanceof PigeonPostBlock);
		if (flag) {
			posts.remove(pos);
			markDirty();
		}
		return flag;
	}
}
