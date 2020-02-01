package com.bteteam.bte.blocks.tileentities;

import com.bteteam.bte.net.NetHandler;
import com.bteteam.bte.net.packet.PacketUpdateTE;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.stream.Stream;

import static net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;

public class TileEntityInfernalForge extends TileEntity {


	private ItemStackHandler stackHandler = new ItemStackHandler(1) {

		@Override
		public int getSlotLimit(int slot) {
			return 1;
		}

		@Override
		protected void onContentsChanged(int slot) {
			super.onContentsChanged(slot);
			markDirty();
		}
	};

	public TileEntityInfernalForge() {
		super(TileEntityTypes.infernalforge);
	}

	public ItemStackHandler getStackHandler() {
		return stackHandler;
	}

	@Override
	public void onLoad() {
		super.onLoad();
	}

	@Override
	public CompoundNBT write(CompoundNBT nbt) {
		super.write(nbt);
		nbt.put("inventory", Optional.ofNullable(ITEM_HANDLER_CAPABILITY.writeNBT(stackHandler, Direction.DOWN)).orElse(new CompoundNBT()));
		return nbt;
	}

	@Override
	public void read(CompoundNBT nbt) {
		super.read(nbt);
		ITEM_HANDLER_CAPABILITY.readNBT(stackHandler, Direction.DOWN, nbt.get("inventory"));
		if (world.isRemote) {
			return;
		}
		markDirty();
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
		return cap == ITEM_HANDLER_CAPABILITY ? LazyOptional.of(() -> (T) stackHandler) : LazyOptional.empty();
	}

	@Override
	public void markDirty() {
		sendUpdates();
		super.markDirty();
	}

	private void sendUpdates() {
		if (!world.isRemote) {
			CompoundNBT nbt = new CompoundNBT();
			write(nbt);
			NetHandler.UPDATE.send(PacketDistributor.ALL.noArg(), new PacketUpdateTE(pos, nbt));
		}
	}

	public boolean canSmelt() {
		Stream<AbstractCookingRecipe> abstractCookingRecipeStream = world.getRecipeManager().getRecipes().stream().filter(r -> r instanceof AbstractCookingRecipe).map(r -> (AbstractCookingRecipe) r);
		return abstractCookingRecipeStream.map(this::canSmelt).reduce(false, Boolean::logicalOr);
	}

	public boolean canSmelt(AbstractCookingRecipe recipe) {
		if (recipe.getIngredients().size() != 1) {
			return false;
		}
		ItemStack toMatch = stackHandler.getStackInSlot(0);
		boolean flag = false;
		for (Ingredient ingredient : recipe.getIngredients()) {
			flag = flag || ingredient.test(toMatch);
		}
		return flag;
	}

	public Optional<AbstractCookingRecipe> getRecipe() {
		Stream<AbstractCookingRecipe> abstractCookingRecipeStream = world.getRecipeManager().getRecipes().stream().filter(r -> r instanceof AbstractCookingRecipe).map(r -> (AbstractCookingRecipe) r);
		return abstractCookingRecipeStream.filter(this::canSmelt).findAny();
	}
}
