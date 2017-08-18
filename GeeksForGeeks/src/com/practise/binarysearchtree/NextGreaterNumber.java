package com.practise.binarysearchtree;

import com.practise.trees.Node;

/*
 * 
 * http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 */
public class NextGreaterNumber {
	
	public static void main(String[] args) {
		Node node20 = new Node(20);
		Node node8 = new Node(8);
		Node node4 = new Node(4);
		Node node12 = new Node(12);
		Node node10 = new Node(10);
		Node node14 = new Node(14);
		Node node22 = new Node(22);
		Node node21 = new Node(21);
		Node node23 = new Node(23);
		
		node20.setLeft(node8);
		node8.setLeft(node4);
		node8.setRight(node12);
		node12.setLeft(node10);
		node12.setRight(node14);
		
		node20.setRight(node22);
		node22.setLeft(node21);
		node22.setRight(node23);
		
		Node root = node20;
		
		//printInOrder(root);
		
		int number = 27;
		
		Node nextGreaterNode = findNextLargestNumber(root, number);
		if(nextGreaterNode != null){
			System.out.println(nextGreaterNode.getValue());
		}else{
			System.out.println("does not exits");
		}
	}

	private static Node findNextLargestNumber(Node root, int number) {
		Node successor = null;
		while(root != null){
			if(number < root.getValue()){
				successor = root;
				root = root.getLeft();
			}else{
				root = root.getRight();
			}
		}
		
		return successor;
	}

	private static void printInOrder(Node root) {
		if(root != null){
			printInOrder(root.getLeft());
			System.out.print(root.getValue()+ " ");
			printInOrder(root.getRight());
		}
	}

}
