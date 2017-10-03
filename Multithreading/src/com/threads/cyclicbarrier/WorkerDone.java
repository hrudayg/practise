package com.threads.cyclicbarrier;

public class WorkerDone implements Runnable {

	@Override
	public void run() {
		mergeRows();
	}

	void mergeRows() {
		System.out.println("merging");
		synchronized ("abc") {
			"abc".notify();
		}
	}
}
