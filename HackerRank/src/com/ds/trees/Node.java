package com.ds.trees;

public class Node {

	int data;
	Node left;
	Node right;

	public Node(int value, Node left, Node right) {
		super();
		this.data = value;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [value=" + data + ", left=" + left + ", right=" + right + "]";
	}

}
