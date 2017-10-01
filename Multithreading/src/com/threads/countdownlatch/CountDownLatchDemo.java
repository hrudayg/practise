package com.threads.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

	private static final int NTHREADS = 3;
	final CountDownLatch mainThreadSignal = new CountDownLatch(1);
	final CountDownLatch executorThreadSignal = new CountDownLatch(NTHREADS);

	public static void main(String[] args) {
		CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
		ExecutorService executors = Executors.newFixedThreadPool(NTHREADS);
		CountDownRunnable countDownRunnable = new CountDownRunnable(countDownLatchDemo);
		System.out.println("Main thread starting worker threads");
		for (int nThread = 0; nThread < NTHREADS; nThread++) {
			executors.submit(countDownRunnable);
		}
		
		try {
			System.out.println("main Thread sleeping for 1 sec");
			Thread.sleep(1000);
			countDownLatchDemo.mainThreadSignal.countDown();
			countDownLatchDemo.executorThreadSignal.await();
			System.out.println("executor threds work done");
			executors.shutdown();
		} catch (Exception e) {
			System.out.println("exception in main thread "+e);
		}

	}

}
