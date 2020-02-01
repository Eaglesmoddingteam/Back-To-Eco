package com.bteteam.bte.summoning.ritual;

import com.bteteam.bte.blocks.tileentities.TileEntityInfernalTile;
import com.bteteam.bte.summoning.task.Task;
import com.bteteam.bte.summoning.task.Tasks;

import java.util.*;

public abstract class AbstractSummoningRitual {

	private static Random random = new Random();
	protected final TileEntityInfernalTile.Master masterTile;
	private Deque<Task> tasks = new LinkedList<>();
	private int currentstage = 0;
	private int currentturn = 0;
	private int ticks = 0;

	public AbstractSummoningRitual(TileEntityInfernalTile.Master masterTile) {
		this.masterTile = masterTile;
	}

	/**
	 * summons the entity, called when the ritual is completed.
	 */
	protected abstract void spawnEntity();

	/**
	 * @return the amount of stages in this ritual
	 */
	protected abstract int getStages();

	/**
	 * @param stage the stage of the ritual (0 to this::getStages-1)
	 * @return the speed multiplier of the current stage
	 */
	protected abstract float getSpeed(int stage);

	/**
	 * @param stage the stage of the ritual (0 to this::getStages-1)
	 * @param turn  the turn in this stage (0 to this::getTurns-1)
	 * @return the max amount of tiles to go into 'broken state' each turn
	 */
	protected abstract int getDifficulty(int stage, int turn);

	/**
	 * @param stage the stage of the ritual (0 to this::getStages-1)
	 * @return the amount of turns in the current stage
	 */
	protected abstract int getTurns(int stage);

	public void execute() {
		if (!tasks.isEmpty()) {
			if (tasks.peek().delay() <= ++ticks) {
				tasks.pop().run();
				ticks = 0;
			}
			return;
		}
		if (++currentturn == getTurns(currentstage)) {
			currentturn = 0;
			currentstage++;
		}
		if (currentstage == getStages()) {
			this.spawnEntity();
			masterTile.completed();
			return;
		}
		System.out.println("stage " + currentstage + ";turn " + currentturn);
		Set<Integer> blocks = new HashSet<>();
		while (blocks.size() < getDifficulty(currentstage, currentturn)) {
			int generated = random.nextInt(9);
			blocks.add(generated);
		}
		int[] ints = blocks.stream().mapToInt(Integer::intValue).toArray();
		tasks.addLast(Tasks.toNextStage(ints, this.masterTile, 20));
		tasks.addLast(Tasks.toNextStage(ints, this.masterTile, (int) (30 / getSpeed(currentstage))));
		tasks.addLast(Tasks.resetStage(ints, this.masterTile, 5));
	}

}
