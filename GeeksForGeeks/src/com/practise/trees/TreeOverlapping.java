package com.practise.trees;

/**
 * http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
 * 
 * @author hruday.g
 * 
 */
public class TreeOverlapping {

	public static void main(String[] args) {
		Node root1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);

		root1.setLeft(node2);
		root1.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		node3.setRight(node7);

		Node root2 = new Node(3);
		Node node8 = new Node(6);
		Node node9 = new Node(7);
		root2.setLeft(node8);
		root2.setRight(node9);
		
		boolean isOverlapping = findIsTreeOverlapping(root1, root2);
		System.out.println(isOverlapping);
	}
	
	/*
	 * O(mn)  solution
	 */

	private static boolean findIsTreeOverlapping(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if((node1 == null && node2 != null) || (node1 != null && node2 == null)){
			return false;
		}
		
		if (node1.getValue() == node2.getValue()) {
			boolean isLeftOverlapping = findIsTreeOverlapping(node1.getLeft(), node2.getLeft());
			boolean isRightOverlapping = findIsTreeOverlapping(node1.getRight(), node2.getRight());
			return isLeftOverlapping && isRightOverlapping;
		}else{
			boolean checkLeft = findIsTreeOverlapping(node1.getLeft(), node2);
			boolean checkRight = findIsTreeOverlapping(node1.getRight(), node2);
			return checkLeft || checkRight;
		}

	}

}
