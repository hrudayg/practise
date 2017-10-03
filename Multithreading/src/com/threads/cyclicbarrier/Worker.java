package com.threads.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;

public class Worker implements Runnable {

	private Solver solver;
	private int myRow;
	private boolean done;

	@Override
	public void run() {
		while (!done()) {
			processRow(myRow);
			try {
				solver.cyclicBarrier.await();
			} catch (InterruptedException ie) {
				return;
			} catch (BrokenBarrierException bbe) {
				return;
			}
		}
	}

	public Worker(Solver solver, int row) {
		this.solver = solver;
		this.myRow = row;
	}

	boolean done() {
		return done;
	}

	void processRow(int myRow) {
		System.out.println("Processing row: " + myRow);
		for (int i = 0; i < solver.length; i++)
			solver.data[myRow][i] *= 10;
		done = true;
	}

}
