package com.bteteam.bte.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class NBTUtil {

	public static CompoundNBT toNBT(ItemStack stack) {
		CompoundNBT nbt = new CompoundNBT();
		nbt.putInt("size", stack.getCount());
		nbt.putString("item", stack.getItem().getRegistryName().toString());
		return nbt;
	}

	public static ItemStack stackFromNBT(CompoundNBT nbt) {
		Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(nbt.getString("item")));
		return new ItemStack(item, nbt.getInt("size"));
	}

	public static CompoundNBT toNBT(ItemStack[] itemStacks) {
		CompoundNBT nbt = new CompoundNBT();
		for (int i = 0; i < itemStacks.length; i++) {
			nbt.put("" + i, toNBT(itemStacks[i]));
		}
		nbt.putInt("lenth", itemStacks.length);
		return nbt;
	}

	public static ItemStack[] stacksFromNBT(CompoundNBT nbt) {
		int length = nbt.getInt("length");
		ItemStack[] itemStacks = new ItemStack[length];
		for (int i = 0; i < length; i++) {
			itemStacks[i] = stackFromNBT((CompoundNBT) nbt.get("" + i));
		}
		return itemStacks;
	}

}
