package com.practise.binarysearchtree;

import com.practise.trees.Node;

public class LCABinarySearchTree {

	public static void main(String[] args) {
		Node node = createBinarySearchTree();
		System.out.println(node);
		Node lca = findLCA(node, 8, 14);
		System.out.println(lca.getValue());
	}

	private static Node findLCA(Node node, int first, int second) {
		if (node != null) {
			int value = node.getValue();
			if (value > first && value > second) {
				return findLCA(node.getLeft(), first, second);
			}
			if(value < first && value < second){
				return findLCA(node.getRight(), first, second);
			}
			return node;
		}
		return null;
	}

	private static Node createBinarySearchTree() {
		Node root = new Node(20);
		Node node1 = new Node(8);
		Node node2 = new Node(22);
		Node node3 = new Node(4);
		Node node4 = new Node(12);
		Node node5 = new Node(10);
		Node node6 = new Node(14);

		root.setLeft(node1);
		root.setRight(node2);

		node1.setLeft(node3);
		node1.setRight(node4);

		node4.setLeft(node5);
		node4.setRight(node6);

		return root;
	}

}
