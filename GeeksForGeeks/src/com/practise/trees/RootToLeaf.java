package com.practise.trees;

import java.util.Arrays;

public class RootToLeaf {
	
	public static void main(String[] args) {
		int[] inputArr = {0, 1, 2, 3, 4, 5, 6};
		Node root = null;
		root = createBinaryTree(root, inputArr, 0);
		System.out.println(root);
		
		findRootToLeafPath(root);
		
	}
	
	private static int findHeightOfTree(Node root) {
		if(root != null){
			int leftHeight = findSizeOfTree(root.getLeft());
			int rightHeight = findSizeOfTree(root.getRight());
			return Math.max(leftHeight, rightHeight) + 1;
		}
		return 0;
	}

	private static void findRootToLeafPath(Node root) {
		int height = findHeightOfTree(root);
		int[] path = new int[height];
		findRootToLeafPath(root, path, 0);
	}

	private static void findRootToLeafPath(Node root, int[] path, int index) {
		if(root != null){
			path[index] = root.getValue();
			if(root.getLeft() == null && root.getRight() == null){
				System.out.println(Arrays.toString(path));
			}else{
				findRootToLeafPath(root.getLeft(), path, index + 1);
				findRootToLeafPath(root.getRight(), path, index + 1);
			}
		}
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
