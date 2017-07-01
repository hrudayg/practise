package com.practise.trees;

public class TreeUtil {
	
	public static Node createBinaryTree(Node node, int[] input, int index) {
		if(index >= input.length){
			return null;
		}
		
		node = new Node(input[index]);
		node.setLeft(createBinaryTree(node, input, (2 * index) + 1));
		node.setRight(createBinaryTree(node, input, (2 * index) + 2));
		
		return node;
	}

}
