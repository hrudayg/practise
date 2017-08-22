package com.practise.linkedlist;

/**
 * 
 * http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 * @author hruday.g
 *
 */
public class LinkedListKReversal {
	
	public static void main(String[] args) {
		int[] inputArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		LinkedList linkedList = LinkedListUtil.createLinkedList(inputArr);
		LinkedListNode newRoot = reversalLinkedListKElements(linkedList.head, 3);
		System.out.println(newRoot);
	}

	private static LinkedListNode reversalLinkedListKElements(LinkedListNode head, int number) {
		
		LinkedListNode previous = null;
		LinkedListNode temp = head;
		
		int count = 0;
		while(head != null && count < number){
			LinkedListNode next = head.next;
			head.next = previous;
			previous = head; 
			head = next;
			count++;
		}
		
		
		if(head != null){
			temp.next = reversalLinkedListKElements(head, number);
		}
		
		return previous;
		
	}
	
	
}
