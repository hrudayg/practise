package com.threads.oddeven;

public class OddRunnable implements Runnable {

	private OddEven oddEven;
	private int totalNumbers;
	
	public OddRunnable(OddEven oddEven, int totalNumbers) {
		this.oddEven = oddEven;
		this.totalNumbers = totalNumbers;
	}

	@Override
	public void run() {
		synchronized (oddEven) {
			int count = 1;
			while(count <= totalNumbers){
				try {
					while(oddEven.isEvenTurn){
						oddEven.wait();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Thread is :"+Thread.currentThread().getName()+" number  :"+count);
				oddEven.isEvenTurn = true;
				count = count + 2;
				oddEven.notify(); 
			}
		}
	}
	
}
