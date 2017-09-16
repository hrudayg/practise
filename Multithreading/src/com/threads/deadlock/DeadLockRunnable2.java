package com.threads.deadlock;

public class DeadLockRunnable2 implements Runnable{
	
	private DeadLock deadLock;
	
	public DeadLockRunnable2(DeadLock deadLock) {
		super();
		this.deadLock = deadLock;
	}

	@Override
	public void run() {
		while(true){
			try {
				deadLock.instanceMethod2();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
