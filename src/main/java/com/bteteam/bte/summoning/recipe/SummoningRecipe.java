package com.bteteam.bte.summoning.recipe;

import com.bteteam.bte.blocks.tileentities.TileEntityInfernalTile;
import com.bteteam.bte.summoning.ritual.AbstractSummoningRitual;
import com.bteteam.bte.summoning.ritual.DefaultSummonningRitual;
import com.bteteam.bte.util.ArrayUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;

public class SummoningRecipe implements IForgeRegistryEntry<SummoningRecipe> {

	public static IForgeRegistry<SummoningRecipe> recipes;
	private final EntitySupplier<?> supplier;
	private ResourceLocation registryName;
	private final Item[] ingredients;

	@Nullable
	public static SummoningRecipe getEntry(Item[] items){
		return recipes.getValues().stream().filter(summoningRecipe -> ArrayUtil.smartCompare(summoningRecipe.getIngredients(), items)).findAny().orElse(null);
	}

	public <T extends LivingEntity> SummoningRecipe(EntitySupplier<T> supplier, Item... ingredients) {
		this.supplier = supplier;
		this.ingredients = ingredients;
	}

	@Nullable
	@Override
	public ResourceLocation getRegistryName() {
		return registryName;
	}

	@Override
	public SummoningRecipe setRegistryName(ResourceLocation name) {
		this.registryName = name;
		return this;
	}

	@Override
	public Class<SummoningRecipe> getRegistryType() {
		return SummoningRecipe.class;
	}

	public AbstractSummoningRitual getRitual(TileEntityInfernalTile.Master master) {
		return new DefaultSummonningRitual<>(master, supplier.supply(master.getWorld()));
	}

	public Item[] getIngredients(){
		return ingredients;
	}
}
