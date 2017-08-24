package com.threads.oddeven;

public class EvenRunnable implements Runnable{

	private OddEven oddEven;
	private int totalNumbers;
	
	public EvenRunnable(OddEven oddEven, int totalNumers) {
		this.oddEven = oddEven;
		this.totalNumbers = totalNumers;
	}

	@Override
	public void run() {

		synchronized (oddEven) {
			int count = 2;
			while(count <= totalNumbers){
				try {
					while(!oddEven.isEvenTurn){
						oddEven.wait();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("Thread is :"+Thread.currentThread().getName()+" number  :"+count);
				count = count + 2;
				oddEven.isEvenTurn = false;
				oddEven.notify(); 
			}
		}
	
	}

}
