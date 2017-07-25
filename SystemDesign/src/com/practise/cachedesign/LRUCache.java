package com.practise.cachedesign;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.omg.CORBA.portable.ValueInputStream;

/*
 * This is a LRUCache . 
 * This cache has the most recently used object in the head and the least recently used one in the tail
 * 
 */
public class LRUCache {

	private int length;

	private Node head;

	private Node tail;

	private Map<Integer, Node> valueNodeMap;

	private int count;

	public LRUCache(int length) {
		super();
		this.length = length;
		valueNodeMap = new HashMap<>(length);
	}

	public boolean add(int key, int value) {
		// if the cache is full
		Node node = new Node(key, value);
		if (count == length) {
			removeLRUNode();
		}
		addNodeToCache(node);
		return true;
	}

	private Node addNodeToCache(Node node) {
		// actual adding of object to cache
		addFirst(node);
		valueNodeMap.put(node.getKey(), node);
		count++;
		return node;
	}

	private void addFirst(Node node) {
		if (head == null || count == 0) {
			this.head = node;
		} else {
			Node tempHead = head.getNext();
			this.head = node;
			head.setNext(tempHead);
			tempHead.setPrevious(this.head);
		}
	}

	private void removeLRUNode() {
		// remove the least recently used node
		Node removedNode = this.tail;
		Node previousNode = this.tail.getPrevious();
		this.tail = previousNode;
		int removedNodeKey = removedNode.getKey();
		System.out.println("removed node key is :" + removedNodeKey);
		valueNodeMap.remove(removedNodeKey);
		count--;
	}

	private int get(int key) {
		Node node = valueNodeMap.get(key);
		if (node != null) {
			removeNode(node);
			addNodeToCache(node);
			return node.getValue();
		} else {
			System.out.println("key is not present in the cache - adding to the cache");
			return -1;
		}
	}

	private void removeNode(Node node) {
		Node previousNode = node.getPrevious();
		Node nextNode = node.getNext();
		if (previousNode != null) {
			previousNode.setNext(nextNode);
		} else {
			this.head = nextNode;
		}

		if (nextNode != null) {
			nextNode.setPrevious(previousNode);
		} else {
			this.tail = previousNode;
		}

		valueNodeMap.remove(node.getKey());
		count--;

	}

}
