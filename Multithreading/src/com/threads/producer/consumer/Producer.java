package com.threads.producer.consumer;

public class Producer implements Runnable{
	
	public Shared shared;
	

	public Producer(Shared shared) {
		super();
		this.shared = shared;
	}

	@Override
	public void run() {
		System.out.println("producer run method");
		for(char ch = 'A'; ch < 'Z'; ch++){
			synchronized (shared) {
				shared.setSharedChar(ch);
				System.out.println("producer produced "+ch);
			}
			
		}
	}

}
