package com.threads.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class Solver {

	int[][] data = null;
	int length = 0;
	CyclicBarrier cyclicBarrier = null;
	public boolean done;

	public Solver() {

	}

	public Solver(int[][] matrix, int length) {
		this.data = matrix;
		this.length = length;
		cyclicBarrier = new CyclicBarrier(length, new WorkerDone());

		for (int row = 0; row < length; row++) {
			Thread thread = new Thread(new Worker(this, row));
			thread.start();
		}
		waitUntilDone();
	}

	private void waitUntilDone() {
		synchronized ("abc") {
			try {
				System.out.println("main thread waiting");
				"abc".wait();
				System.out.println("main thread notified");
			} catch (InterruptedException ie) {
				System.out.println("main thread interrupted");
			}
		}
	}

}
