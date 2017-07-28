package com.practise.linkedlist;

public class LinkedListUtil {
	
	public static LinkedList createLinkedList(int[] inputArray){
		LinkedList aList = new LinkedList();
		LinkedListNode previous = null;
		LinkedListNode current = null;
		for(int index = 0; index < inputArray.length; index++){
			current = new LinkedListNode(inputArray[index]);
			if(previous != null){
				previous.next = current;
			}else{
				aList.head = current;
			}
			previous = current;
		}
		return aList;
	}

}
