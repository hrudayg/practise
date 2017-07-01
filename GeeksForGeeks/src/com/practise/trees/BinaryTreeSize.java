package com.practise.trees;

public class BinaryTreeSize {
	
	public static void main(String[] args) {
		int[] inputArr = {0, 1, 2, 3, 4, 5, 6};
		Node root = null;
		root = createBinaryTree(root, inputArr, 0);
		System.out.println(root);
		
		int size = findSizeOfTree(root);
		System.out.println(size);
	}

	private static int findSizeOfTree(Node root) {
		if(root != null){
			int left = findSizeOfTree(root.getLeft());
			int right = findSizeOfTree(root.getRight());
			return left + right + 1;
		}
		return 0;
		
	}

	private static Node createBinaryTree(Node node, int[] input, int index) {
		if(index >= input.length){
			return null;
		}
		
		node = new Node(input[index]);
		node.setLeft(createBinaryTree(node, input, (2 * index) + 1));
		node.setRight(createBinaryTree(node, input, (2 * index) + 2));
		
		return node;
	}

}
