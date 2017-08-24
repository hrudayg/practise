package com.threads.oddeven;

/*
 * print odd numbers in one thread and print even numbers in other thread
 * like 
 * 
 * Thread1 : 1, Thread2 : 2 , Thread1 : 3, Thread2: 4 .... and so on
 * 
 */
public class OddEven {
	
	public boolean isEvenTurn = false;
	
	public static void main(String[] args) {
		OddEven oddEven = new OddEven();
		oddEven.printOddEvenNumbers(10);
	}

	private void printOddEvenNumbers(int totalNumers) {
		System.out.println("in printing odd even");
		Thread oddThread = new Thread(new OddRunnable(this, totalNumers), "oddThread");
		Thread evenThread = new Thread(new EvenRunnable(this, totalNumers), "evenThread");
		
		oddThread.start();
		evenThread.start();

		try {
			oddThread.join();
			evenThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("done printing");
		
	}

}
