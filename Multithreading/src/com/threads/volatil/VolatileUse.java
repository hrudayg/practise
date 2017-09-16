package com.threads.volatil;

public class VolatileUse {
	
	public static void main(String[] args) {
		
		VolatileUse volatileUse = new VolatileUse();
		
		volatileUse.impl();
		
	}

	private void impl() {
		
		Runnable volatileRunnable = new VolatileRunnable();
		
		Thread thread = new Thread(volatileRunnable);
		thread.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		((VolatileRunnable) volatileRunnable).stopped();
	}

}
