package com.practise.trees;

/**
 * 
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 * 
 * @author hrudayg
 *
 */
public class IsSumTree {

	public static void main(String[] args) {
		Node root = new Node(26);
		Node node1 = new Node(10);
		Node node2 = new Node(4);
		Node node3 = new Node(6);
		Node node4 = new Node(3);
		Node node5 = new Node(3);

		root.setLeft(node1);
		node1.setLeft(node2);
		node1.setRight(node3);

		root.setRight(node4);
		node4.setRight(node5);

		boolean isSumTree = isSumTree(root);
		System.out.println("the given tree is isSumTree : "+isSumTree);
	}

	private static boolean isSumTree(Node node) {
		int leftSum = 0;
		int rightSum = 0;
		
		if(node == null || isLeafNode(node)){
			return true;
		}
		
		if(isSumTree(node.getLeft()) && isSumTree(node.getRight())) {
			
			if(node.getLeft() != null && isLeafNode(node.getLeft())) {
				leftSum = node.getLeft().getValue();
			}
			if(node.getLeft() != null && !isLeafNode(node.getLeft())) {
				leftSum = 2 * node.getLeft().getValue();
			}
			
			if(node.getRight() != null && isLeafNode(node.getRight())) {
				rightSum = node.getRight().getValue();
			}
			if(node.getRight() != null && !isLeafNode(node.getRight())) {
				rightSum = 2 * node.getRight().getValue();
			}
				
			if(node.getValue() == (leftSum + rightSum)) {
				return true;
			}
			
			return false;
			
		}
				
		return false;
	}

	private static boolean isLeafNode(Node node) {
		if(node == null) {
			return false;
		}
		
		if(node.getLeft() == null && node.getRight() == null) {
			return true;
		}
		return false;
	}
	
}
	
	
