package com.threads.countdownlatch;

public class CountDownRunnable implements Runnable{
	
	private CountDownLatchDemo countDownLatchDemo;
	
	public CountDownRunnable(CountDownLatchDemo countDownLatchDemo) {
		this.countDownLatchDemo = countDownLatchDemo;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("in run method of count down runnable");
			countDownLatchDemo.mainThreadSignal.await();
			String threadName = Thread.currentThread().getName();
			System.out.println("thread "+threadName + " sleeping for 3 secs");
			Thread.sleep(3000);
			System.out.println("thread "+threadName +" done doing job");
			countDownLatchDemo.executorThreadSignal.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
