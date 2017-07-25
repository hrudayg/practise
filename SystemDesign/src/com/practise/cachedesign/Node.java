package com.practise.cachedesign;

public class Node {
	
	private int value;
	
	private int key;
	
	private Node next;
	
	private Node previous;
	
	public Node(int key, int value) {
		super();
		this.value = value;
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

}
