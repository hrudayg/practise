package com.practise.linkedlist;

public class LinkedListNode {
	
	int value;
	LinkedListNode next;

	public LinkedListNode(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "LinkedListNode [value=" + value + ", next=" + next + "]";
	}
	
}
