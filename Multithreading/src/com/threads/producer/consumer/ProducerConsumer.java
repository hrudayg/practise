package com.threads.producer.consumer;

public class ProducerConsumer {

	public static void main(String[] args) {
		Shared shared = new Shared();
		Producer producerRunnble = new Producer(shared);
		Consumer consumerRunnable = new Consumer(shared);

		Thread producerThread = new Thread(producerRunnble, "producerThread");
		Thread consumerThread = new Thread(consumerRunnable, "consumerThread");

		producerThread.start();
		consumerThread.start();
		
		
		try {
			producerThread.join();
			consumerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
