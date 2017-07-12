package com.practise.trees;

public class InorderPreorder {
	
	private static int preorderIndex = 0;
	
	public static void main(String[] args) {

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		node1.setLeft(node2);
		node1.setRight(node5);

		node2.setLeft(node3);
		node2.setRight(node4);

		node5.setLeft(node6);

		//System.out.println(node1);

		printInOrder(node1);
		System.out.println();
		printPreOrder(node1);

		int[] inorderArr = { 3, 2, 4, 1, 6, 5 };
		int[] preorderArr = { 1, 2, 3, 4, 5, 6 };

		Node node = null;

		node = buildBinaryTree(node, inorderArr, preorderArr, 0, inorderArr.length - 1);
		System.out.println();
		//System.out.println(node);
		printInOrder(node);
		System.out.println();
		printPreOrder(node);
	}

	private static Node buildBinaryTree(Node node, int[] inorderArr, int[] preorderArr, int inorderStart, int inorderEnd) {
		if (inorderStart > inorderEnd) {
			return null;
		}
		
		int data = preorderArr[preorderIndex++];
	
		if(inorderStart == inorderEnd){
			return new Node(data);
		}
		
		
		node = new Node(data);
		
		boolean found = false;
		int index = -1;
		for(index = inorderStart; index <= inorderEnd; index++){
			if(data == inorderArr[index]){
				found = true;
				break;
			}
		}
		if(found){
			node.setLeft(buildBinaryTree(node, inorderArr, preorderArr, inorderStart, index - 1));
			node.setRight(buildBinaryTree(node, inorderArr, preorderArr, index + 1, inorderEnd));
		}
		
		return node;
	}

	private static void printPreOrder(Node node) {
		if (node != null) {
			System.out.print(node.getValue() + " ");
			printPreOrder(node.getLeft());
			printPreOrder(node.getRight());
		}

	}

	private static void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.getLeft());
			System.out.print(node.getValue() + " ");
			printInOrder(node.getRight());
		}

	}
}
