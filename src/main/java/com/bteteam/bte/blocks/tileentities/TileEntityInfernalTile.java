package com.bteteam.bte.blocks.tileentities;

import com.bteteam.bte.summoning.recipe.SummoningRecipe;
import com.bteteam.bte.summoning.ritual.AbstractSummoningRitual;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

public class TileEntityInfernalTile extends TileEntity implements ITickableTileEntity {

	Master master = null;
	int tick = 0;

	public TileEntityInfernalTile() {
		super(TileEntityTypes.infernaltile);
	}

	@Override
	public void tick() {
		if (++tick != 20 || world.isRemote) {
			tick %= 20; //to make sure the client doesn't overflow the int.
			return;
		}
		tick = 0;
		if (master != null && master.isInStructure(this.pos)) {
			return;
		}
		setOwnedBy(null);
		for (int x = -1; x <= 1; x++) {
			for (int z = -1; z <= 1; z++) {
				BlockPos pos = this.pos.add(x, 0, z);
				TileEntity tileEntity = world.getTileEntity(pos);
				if (!(tileEntity instanceof TileEntityInfernalTile)) {
					return;
				}
			}
		}
		world.setTileEntity(this.pos, new Master());
	}

	private void setOwnedBy(Master master) {
		this.master = master;
	}

	public static class Master extends TileEntity implements ITickableTileEntity {

		boolean initialized = false;
		boolean iscomplete = true;
		PlayerEntity summoner;
		AbstractSummoningRitual ritual;
		int tick = 0;

		Master() {
			super(TileEntityTypes.infernaltilemaster);
			System.out.println("master made @" + pos.toString());
		}

		public PlayerEntity getSummoner() {
			return summoner;
		}

		boolean isSummoning() {
			return iscomplete && ritual != null;
		}

		void init() {
			initialized = true;
			for (int x = -1; x <= 1; x++) {
				for (int z = -1; z <= 1; z++) {
					if (x == 0 && z == 0) {
						continue;
					}
					BlockPos pos = this.pos.add(x, 0, z);
					TileEntity tileEntity = world.getTileEntity(pos);
					TileEntityInfernalTile tile = (TileEntityInfernalTile) tileEntity;
					tile.setOwnedBy(this);
				}
			}
		}

		@Override
		public void tick() {
			if (this.ritual != null) {
				if (summoner == null || checkSummoner() && Math.abs(summoner.getPosition().subtract(this.pos).getY()) < 2) {
					ritual = null;
				} else {
					ritual.execute();
				}
			}
			if (++tick != 20 || world.isRemote) {
				return;
			}
			tick = 0;
			if (!initialized) {
				init();
			}
			if (!iscomplete) {
				for (int x = -1; x <= 1; x++) {
					for (int z = -1; z <= 1; z++) {
						BlockPos pos = this.pos.add(x, 0, z);
						TileEntity tileEntity = world.getTileEntity(pos);
						if (!(tileEntity instanceof TileEntityInfernalTile))
							continue;
						TileEntityInfernalTile tile = (TileEntityInfernalTile) tileEntity;
						tile.setOwnedBy(null);
					}
				}
				world.setTileEntity(this.pos, new TileEntityInfernalTile());
			}

			for (int x = -1; x <= 1; x++) {
				for (int z = -1; z <= 1; z++) {
					if (x == 0 && z == 0) {
						continue;
					}
					BlockPos pos = this.pos.add(x, 0, z);
					TileEntity tileEntity = world.getTileEntity(pos);
					if (!(tileEntity instanceof TileEntityInfernalTile)) {
						iscomplete = false;
						this.ritual = null;
						return;
					}
				}
			}
		}

		private boolean checkSummoner() {
			BlockPos base = pos.add(-1, 1, -1);
			AxisAlignedBB AABB = new AxisAlignedBB(base, base.add(2, 0, 2));
			return world.getEntitiesWithinAABB(Entity.class, AABB).contains(summoner);
		}

		boolean isInStructure(BlockPos tile, boolean checkY) {
			return Math.abs(this.pos.subtract(tile).getX()) < 2 && Math.abs(this.pos.subtract(tile).getZ()) < 2 && iscomplete && (!checkY || pos.getY() == tile.getY());
		}

		boolean isInStructure(BlockPos tile) {
			return isInStructure(tile, true);
		}

		public void completed() {
			this.ritual = null;
		}

		public void onActivated(PlayerEntity playerEntity) {
			if (!isSummoning()) {
				Item[] items = getItems();
				SummoningRecipe entry = SummoningRecipe.getEntry(items);
				if (entry != null) {
					this.ritual = entry.getRitual(this);
					for (Direction direction : Direction.Plane.HORIZONTAL) {
						BlockPos pos = this.pos.add(0, 1, 0).offset(direction, 1);
						AxisAlignedBB axisAlignedBB = new AxisAlignedBB(pos);
						world.getEntitiesWithinAABB(ItemEntity.class, axisAlignedBB).forEach(Entity::remove);
					}
					this.summoner = playerEntity;
				}
			}
		}

		private Item[] getItems() {
			List<Item> items = new ArrayList<>();
			for (Direction direction : Direction.Plane.HORIZONTAL) {
				BlockPos pos = this.pos.add(0, 1, 0).offset(direction, 1);
				AxisAlignedBB axisAlignedBB = new AxisAlignedBB(pos);
				world.getEntitiesWithinAABB(ItemEntity.class, axisAlignedBB).stream().map(ItemEntity::getItem)//
						.map(ItemStack::getItem).forEach(items::add);
			}
			return items.toArray(new Item[0]);
		}
	}
}
