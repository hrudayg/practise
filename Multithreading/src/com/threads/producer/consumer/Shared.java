package com.threads.producer.consumer;

public class Shared {
	
	private volatile boolean writable;
	
	private char sharedChar;

	public boolean isWritable() {
		return writable;
	}

	public void setWritable(boolean writable) {
		this.writable = writable;
	}

	public char getSharedChar() {
		synchronized (this) {
			while(this.writable){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.writable = true;
			notify();
			return sharedChar;
		}
	}

	public void setSharedChar(char sharedChar) {
		synchronized (this) {
			while(!this.writable){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.writable = false;
			notify();
			this.sharedChar = sharedChar;
		}
	}
	
}
