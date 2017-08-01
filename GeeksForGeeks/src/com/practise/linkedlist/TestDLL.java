package com.practise.linkedlist;

public class TestDLL {
	
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		
		DoublyLinkedListNode oneNode = new DoublyLinkedListNode(1);
		DoublyLinkedListNode twoNode = new DoublyLinkedListNode(2);
		DoublyLinkedListNode threeNode = new DoublyLinkedListNode(3);
		
		dll.add(oneNode);
		dll.add(twoNode);
		
		System.out.println(dll);
		
	}

}
