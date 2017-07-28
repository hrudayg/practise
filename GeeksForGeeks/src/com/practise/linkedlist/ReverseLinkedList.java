package com.practise.linkedlist;

import java.util.Arrays;

public class ReverseLinkedList {
	
	public static void main(String[] args) {
		
		int input[] = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(input));
		
		LinkedList aList = LinkedListUtil.createLinkedList(input);
		System.out.println(aList);
		
		reverse(aList);
		System.out.println(aList);
	}

	private static void reverse(LinkedList aList) {
		LinkedListNode current = aList.head;
		LinkedListNode previous = null;
		LinkedListNode next = null;
		
		while(current != null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		aList.head = previous;
	}

}
