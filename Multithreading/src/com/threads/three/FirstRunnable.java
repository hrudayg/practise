package com.threads.three;

public class FirstRunnable implements Runnable{

	private ThreeThreads threeThreads;
	private int totalNumbers;
	
	public FirstRunnable(ThreeThreads threeThreads, int totalNumbers) {
		this.threeThreads = threeThreads;
		this.totalNumbers = totalNumbers;
	}

	@Override
	public void run() {
		
		synchronized (threeThreads) {
			while(threeThreads.getCurrentNumber() < totalNumbers){
				while(!threeThreads.getThreadName().equals(Thread.currentThread().getName())){
					try {
						threeThreads.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				int currentNumber = threeThreads.getCurrentNumber();
				System.out.println("Thread is : "+Thread.currentThread().getName()+": "+currentNumber);
				currentNumber = currentNumber + 1;
				threeThreads.setCurrentNumber(currentNumber);
				threeThreads.setThreadName("secondThread");
				threeThreads.notifyAll();
			}
		}
		
	}

}
