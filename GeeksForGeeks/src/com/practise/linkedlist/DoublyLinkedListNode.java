package com.practise.linkedlist;

public class DoublyLinkedListNode {
	
	int value;
	
	DoublyLinkedListNode next;
	
	DoublyLinkedListNode previous;

	public DoublyLinkedListNode(int value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return "DoublyLinkedListNode [value=" + value + "]";
	}
	
}
