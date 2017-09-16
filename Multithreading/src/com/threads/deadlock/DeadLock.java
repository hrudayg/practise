package com.threads.deadlock;

public class DeadLock {
	
	private final Object lock1 = new Object();
	
	private final Object lock2 = new Object();
	
	public static void main(String[] args) {
		
		DeadLock deadLock = new DeadLock();
		
		DeadLockRunnable1 deadLockRunnable1 = new DeadLockRunnable1(deadLock);
		
		DeadLockRunnable2 deadLockRunnable2 = new DeadLockRunnable2(deadLock);
		
		Thread firstThread = new Thread(deadLockRunnable1, "firstThread");
		
		Thread secondThread = new Thread(deadLockRunnable2, "secondThread");
		
		firstThread.start();
		
		secondThread.start();
		
		try {
			firstThread.join();
			secondThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void instanceMethod1(){
		System.out.println("Thead "+Thread.currentThread().getName()+" in instance method 1");
		synchronized (lock1) {
			System.out.println("Thread "+Thread.currentThread().getName()+ " acquired lock1");
			synchronized (lock2) {
				System.out.println("first thread executing the instance 1 method");
			}
		}
	}
	 
	public void instanceMethod2(){
		System.out.println("Thead "+Thread.currentThread().getName()+" in instance method 2");
		synchronized (lock2) {
			System.out.println("Thread "+Thread.currentThread().getName()+ " acquired lock2");
			synchronized (lock1) {
				System.out.println("first thread executing the instance 2 method");
			}
		}
	}
	

}
