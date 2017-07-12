package com.practise.binarysearchtree;

import com.practise.trees.Node;

public class TreeBst {

	public static void main(String[] args) {
		Node root = new Node(4);
		Node node2 = new Node(2);
		Node node5 = new Node(5);
		Node node1 = new Node(1);
		Node node3 = new Node(3);

		root.setLeft(node2);
		root.setRight(node5);
		node2.setLeft(node1);
		node2.setRight(node3);

		System.out.println(root);

		isBinarySearchTree(root);
	}

	private static void isBinarySearchTree(Node root) {
		boolean isBST = isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(isBST);
	}

	private static boolean isBinarySearchTree(Node root, int minValue, int maxValue) {
		if (root != null) {

			if (root.getValue() < minValue && root.getValue() > maxValue) {
				return false;
			}

			boolean isLeftBinarySearchTree = isBinarySearchTree(root.getLeft(), minValue, root.getValue() - 1);
			boolean isRightBinarySearchTree = isBinarySearchTree(root.getRight(), root.getValue() + 1, maxValue);
			
			return isLeftBinarySearchTree && isRightBinarySearchTree;
		}
		return true;
	}

}
