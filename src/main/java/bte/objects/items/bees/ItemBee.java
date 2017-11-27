package bte.objects.items.bees;

import bte.objects.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBee extends ItemBase{
	ItemBee worker;
	ItemBee queen;
	private boolean isQueen=false;

	/**
	 * give the queen if the bee is a worker and give the worker if the bee is a queen
	 * @param name
	 * @param tab
	 * @param isQueen
	 * @param queen_Or_Worker
	 */
	public ItemBee(String name, CreativeTabs tab, boolean isQueen, ItemBee queen_Or_Worker) {
		super(name, 64, tab);
		if(!isQueen) {
		this.worker=this;
		this.queen = queen_Or_Worker;
		}else {
			this.isQueen=true;this.queen = this;
			this.worker=queen_Or_Worker;
		}
	}

	public boolean isQueen() {
		return isQueen;
	}

	public ItemBee getQueen() {
		return queen;
	}
	
	public boolean isWorkerOf(ItemBee queen) {
		if (queen.isQueen) {
			return this.queen == queen;
		}else return false;
	}

	public Item getWorker() {
		return worker;
	}

}
