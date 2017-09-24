package com.threads.producer.consumer;

public class Consumer implements Runnable {

	private Shared shared;

	public Consumer(Shared shared) {
		super();
		this.shared = shared;
	}

	@Override
	public void run() {
		System.out.println("Consumer run method");
		char ch = 0;
		while(ch != 'Z'){
			synchronized (shared) {
				ch = shared.getSharedChar();
				System.out.println("consumer consumed "+ch);
			}
		}
		
	}

}
