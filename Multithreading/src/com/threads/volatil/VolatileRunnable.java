package com.threads.volatil;

public class VolatileRunnable implements Runnable{

	public volatile boolean  stopped;
	
	@Override
	public void run() {
		while(!stopped){
			System.out.println("thread is "+Thread.currentThread().getName());
			System.out.println("running");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stopped(){
		System.out.println("thread is "+Thread.currentThread().getName());
		System.out.println("in changing the varibale stopped to true");
		stopped = true;
	}

}
