package com.threads.exception;

public class ExceptionThread {
	
	public static void main(String[] args) {
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				int result = 1/0;
			}
		};
		
		Thread thread = new Thread(runnable, "sampleThread");
		
		
		
		Thread.UncaughtExceptionHandler uceh;
		
		uceh = new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread thread, Throwable exp) {
				System.out.println("Caught throwable "+exp+" for thread "+thread);
			}
		};
		
		//thread.setUncaughtExceptionHandler(uceh);
		
		
		uceh = new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread thread, Throwable exp) {
				System.out.println("defaul exp handler");
				System.out.println("caught throwable "+exp+ " for thread "+thread);
			}
		};
		thread.setDefaultUncaughtExceptionHandler(uceh);
		thread.start();
	}

}
