package com.threads.deadlock;

public class DeadLockRunnable1 implements Runnable{

	private DeadLock deadlock;
	
	public DeadLockRunnable1(DeadLock deadlock) {
		super();
		this.deadlock = deadlock;
	}

	@Override
	public void run() {
		while(true){
			try {
				deadlock.instanceMethod1();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
