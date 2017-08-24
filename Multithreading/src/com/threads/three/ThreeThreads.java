package com.threads.three;


public class ThreeThreads {
	
	private volatile String threadName = "firstThread";
	private volatile int currentNumber = 1;
	
	public static void main(String[] args) {
		ThreeThreads threeThreads = new ThreeThreads();
		threeThreads.printNumbers(16);
	}

	private void printNumbers(int totalNumbers) {
		Thread firstThread = new Thread(new FirstRunnable(this, totalNumbers), "firstThread");
		Thread secondThread = new Thread(new SecondRunnable(this, totalNumbers), "secondThread");
		Thread thirdThread = new Thread(new ThirdRunnable(this, totalNumbers), "thirdThread");
		
		firstThread.start();
		secondThread.start();
		thirdThread.start();
		
		try {
			firstThread.join();
			secondThread.join();
			thirdThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public int getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}
	
}
