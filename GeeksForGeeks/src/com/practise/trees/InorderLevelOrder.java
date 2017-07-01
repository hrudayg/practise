package com.practise.trees;

import java.util.Arrays;
import java.util.Scanner;

public class InorderLevelOrder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();

		for (int i = 0; i < noOfTestCases; i++) {
			int noOfNodes = sc.nextInt();
			int[] inOrderTraversal = new int[noOfNodes];
			int[] levelOrdertravarsal = new int[noOfNodes];
			for (int index = 0; index < noOfNodes; index++) {
				inOrderTraversal[index] = sc.nextInt();
			}

			for (int index = 0; index < noOfNodes; index++) {
				levelOrdertravarsal[index] = sc.nextInt();
			}

			System.out.println(Arrays.toString(inOrderTraversal));
			System.out.println(Arrays.toString(levelOrdertravarsal));
			InorderLevelOrder inorderLevelOrder = new InorderLevelOrder();
			Node root = null;
			root = constructTree(root, inorderLevelOrder, inOrderTraversal, levelOrdertravarsal, 0,
					inOrderTraversal.length - 1);
			//System.out.println(root);
			printPreorderTraversal(root);
		}
	}

	private static void printPreorderTraversal(Node root) {
		if(root != null){
			printPreorderTraversal(root.left);
			System.out.print(root.value+" ");
			printPreorderTraversal(root.right);
		}
		System.out.println("");
	}

	private static Node constructTree(Node startNode, InorderLevelOrder inorderLevelOrder, int[] inOrderTraversal,
			int[] levelOrdertravarsal, int inorderStart, int inorderEnd) {
		if (inorderStart > inorderEnd) {
			return null;
		}

		if (inorderStart == inorderEnd) {
			startNode = inorderLevelOrder.new Node(inOrderTraversal[inorderStart], null, null);
			return startNode;
		}

		int index = -1;
		boolean found = false;
		for (int i = 0; i < levelOrdertravarsal.length; i++) {
			int data = levelOrdertravarsal[i];
			for (int j = inorderStart; j <= inorderEnd; j++) {
				if (data == inOrderTraversal[j]) {
					index = j;
					found = true;
					break;
				}
			}
			if (found)
                break;
		}
		
		startNode = inorderLevelOrder.new Node(inOrderTraversal[index], null, null);
		startNode.left = constructTree(startNode , inorderLevelOrder, inOrderTraversal, levelOrdertravarsal, inorderStart, index - 1);
		startNode.right = constructTree(startNode, inorderLevelOrder, inOrderTraversal, levelOrdertravarsal, index + 1, inorderEnd);

		return startNode;
	}

	class Node {

		int value;
		Node left;
		Node right;

		public Node(int value, Node left, Node right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
		}
		
	}

}
