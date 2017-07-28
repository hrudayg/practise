package com.practise.linkedlist;

public class ReverseLinkedList {
	
	public static void main(String[] args) {
		
		int input[] = {1, 2, 3, 4, 5};
		LinkedList aList = LinkedListUtil.createLinkedList(input);
		System.out.println(aList);
		
		reverse(aList);
		System.out.println(aList);
		
		aList.head = reverseRecursive(aList.head);
		System.out.println(aList);
	}

	private static LinkedListNode reverseRecursive(LinkedListNode head) {
		if (head == null || head.next == null) {  
		    return head;  
		}
		LinkedListNode remaining = reverseRecursive(head.next);
		head.next.next = head; 
		head.next = null;  
		return remaining; 
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
