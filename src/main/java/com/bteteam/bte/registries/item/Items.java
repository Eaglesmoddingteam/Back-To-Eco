package com.bteteam.bte.registries.item;

import com.bteteam.bte.BTECreativeTabs;
import com.bteteam.bte.registries.Registry;
import com.bteteam.bte.registries.item.obj.ItemBase;
import net.minecraft.item.Item;

public class Items implements Registry<Item> {

	@Override
	public Class<? extends Item> getType() {
		return ItemBase.class;
	}

	public ItemBase alien_bee = new ItemBase("alien_bee", BTECreativeTabs.BUGS);
	public ItemBase beatle = new ItemBase("beatle", BTECreativeTabs.BUGS);
	public ItemBase bee = new ItemBase("bee", BTECreativeTabs.BUGS);
	public ItemBase blue_beatle = new ItemBase("blue_beatle", BTECreativeTabs.BUGS);
	public ItemBase butterfly = new ItemBase("butterfly", BTECreativeTabs.BUGS);
	public ItemBase dragonfly = new ItemBase("dragonfly", BTECreativeTabs.BUGS);
	public ItemBase dragonfly2 = new ItemBase("dragonfly2", BTECreativeTabs.BUGS);
	public ItemBase dragonfly3 = new ItemBase("dragonfly3", BTECreativeTabs.BUGS);
	public ItemBase earthworm = new ItemBase("earthworm", BTECreativeTabs.BUGS);
	public ItemBase firefly = new ItemBase("firefly", BTECreativeTabs.BUGS);
	public ItemBase jungle_bee = new ItemBase("jungle_bee", BTECreativeTabs.BUGS);
	public ItemBase ladybird = new ItemBase("ladybird", BTECreativeTabs.BUGS);
	public ItemBase moth = new ItemBase("moth", BTECreativeTabs.BUGS);
	public ItemBase picker_ant = new ItemBase("picker_ant", BTECreativeTabs.BUGS);
	public ItemBase pinchbug = new ItemBase("pinchbug", BTECreativeTabs.BUGS);
	public ItemBase queen_alien = new ItemBase("queen_alien", BTECreativeTabs.BUGS);
	public ItemBase queen_ant = new ItemBase("queen_ant", BTECreativeTabs.BUGS);
	public ItemBase queen_bee = new ItemBase("queen_bee", BTECreativeTabs.BUGS);
	public ItemBase queen_jungle = new ItemBase("queen_jungle", BTECreativeTabs.BUGS);
	public ItemBase shrimp = new ItemBase("shrimp", BTECreativeTabs.BUGS);
	public ItemBase silkworm = new ItemBase("silkworm", BTECreativeTabs.BUGS);
	public ItemBase wasp = new ItemBase("wasp", BTECreativeTabs.BUGS);
	public ItemBase worker_ant = new ItemBase("worker_ant", BTECreativeTabs.BUGS);
	public ItemBase worm = new ItemBase("worm", BTECreativeTabs.BUGS);

}
