package com.bteteam.bte.summoning.task;

public interface Task {

	/**
	 * Runs the task
	 */
	void run();

	/**
	 * @return the amount of ticks delay before this task can be executed
	 */
	int delay();

}
