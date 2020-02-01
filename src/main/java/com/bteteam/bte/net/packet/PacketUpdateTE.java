package com.bteteam.bte.net.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketUpdateTE {

	private final BlockPos pos;

	private final CompoundNBT compoundNBT;

	public PacketUpdateTE(BlockPos pos, CompoundNBT compoundNBT) {
		this.pos = pos;
		this.compoundNBT = compoundNBT;
	}

	public static PacketUpdateTE decrypt(PacketBuffer buffer) {
		BlockPos pos = buffer.readBlockPos();
		CompoundNBT nbt = buffer.readCompoundTag();
		return new PacketUpdateTE(pos, nbt);
	}

	@OnlyIn(Dist.CLIENT)
	private static void handle(PacketUpdateTE packetUpdateTE) {
		if (packetUpdateTE.compoundNBT != null) {
			TileEntity tileEntity = Minecraft.getInstance().world.getTileEntity(packetUpdateTE.pos);
			if (tileEntity != null) {
				tileEntity.read(packetUpdateTE.compoundNBT);
			}
		}
	}

	public void encrypt(PacketBuffer buffer) {
		buffer.writeBlockPos(pos);
		buffer.writeCompoundTag(compoundNBT);
	}

	public void handle(Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		if (context.getDirection().getReceptionSide().isClient()) {
			handle(this);
			context.setPacketHandled(true);
		}
	}

	public BlockPos getPos() {
		return pos;
	}

	public CompoundNBT getCompoundNBT() {
		return compoundNBT;
	}
}
