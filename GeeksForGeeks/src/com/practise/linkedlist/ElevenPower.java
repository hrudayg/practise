package com.practise.linkedlist;
/*
 * Find 11 ^ n when n is a larger number. Which means using of any pow function will give you
 * a overflowed value.
 * 
 */
public class ElevenPower {

	public static void main(String[] args) {

		DoublyLinkedList list = new DoublyLinkedList();

		DoublyLinkedListNode firstNode = new DoublyLinkedListNode(1);
		DoublyLinkedListNode secondNode = new DoublyLinkedListNode(1);

		list.add(firstNode);
		list.add(secondNode);

		int number = 9;

		findPower(list, number - 1);
		
		System.out.println(list);
	}

	private static void findPower(DoublyLinkedList aList, int number) {
		while (number > 0) {
			DoublyLinkedListNode current = aList.tail;
			DoublyLinkedListNode previous = null;
			DoublyLinkedListNode previouslyCreatedNewNode = aList.tail;
			int carry = 0;
			while (current != aList.head) {
				previous = current.previous;
				int currentValue = current.value;
				int previousValue = previous == null ? 0 : previous.value;
				int newValue = currentValue + previousValue + carry;
				carry = newValue / 10;
				newValue = newValue % 10;

				DoublyLinkedListNode newNode = new DoublyLinkedListNode(newValue);
				previouslyCreatedNewNode.previous = newNode;
				newNode.next = previouslyCreatedNewNode;
				newNode.previous = previous;
				

				if (previous != null) {
					previous.next = newNode;
				}

				current = previous;
				previouslyCreatedNewNode = newNode;
			}
			
			if(carry > 0){
				int value = aList.head.value + carry;
				aList.head.value = value;
			}
			
			number--;

		}
	}

}
