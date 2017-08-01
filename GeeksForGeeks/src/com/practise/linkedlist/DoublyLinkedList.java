package com.practise.linkedlist;

//TODO: To add more methods of removing the node
public class DoublyLinkedList {

	DoublyLinkedListNode head;

	DoublyLinkedListNode tail;

	private void addFirst(int value) {
		if (head == null) {
			head = new DoublyLinkedListNode(value);
		}else{
			DoublyLinkedListNode newNode = new DoublyLinkedListNode(value);
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
	}
	
	public void addLast(int value){
		if(tail == null){
			tail = new DoublyLinkedListNode(value);
		}else{
			DoublyLinkedListNode newNode = new DoublyLinkedListNode(value);
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
	}
	
	
	public void addBefore(DoublyLinkedListNode nodeToBeAdded, DoublyLinkedListNode existingNode){
		if(existingNode != null){
			DoublyLinkedListNode previousNode = existingNode.previous;
			nodeToBeAdded.next = existingNode;
			nodeToBeAdded.previous = previousNode;
			existingNode.previous = nodeToBeAdded;
			if(previousNode != null){
				previousNode.next = nodeToBeAdded;
			}else{
				this.head = nodeToBeAdded;
			}
		}
	}
	
	public void addAfter(DoublyLinkedListNode nodeToBeAdded, DoublyLinkedListNode existingNode){
		if(existingNode != null){
			DoublyLinkedListNode nextNode = existingNode.next;
			existingNode.next = nodeToBeAdded;
			nodeToBeAdded.previous = existingNode;
			nodeToBeAdded.next = nextNode;
			if(nextNode != null){
				nextNode.previous = nodeToBeAdded;
			}else{
				this.tail = nodeToBeAdded;
			}
			
		}
	}
	
	public void add(DoublyLinkedListNode nodeToBeAdded){
		if(head == null && tail == null){
			head = nodeToBeAdded;
			tail = nodeToBeAdded;
		}else{
			addAfter(nodeToBeAdded, tail);
		}
	}
	
	@Override
	public String toString() {
        String result = "";
        DoublyLinkedListNode current = head;
        while(current != null){
        	result += current.value + ", ";
            current = current.next;
        }
        return "List: " + result;
}

}
