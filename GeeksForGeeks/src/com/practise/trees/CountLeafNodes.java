package com.practise.trees;

public class CountLeafNodes {

	public static void main(String[] args) {
		int[] inputArr = { 0, 1, 2, 3, 4, 5};
		Node node = null;
		node = TreeUtil.createBinaryTree(node, inputArr, 0);
		System.out.println(node);
		int leafs = countNoOfLeaf(node);
		System.out.println(leafs);
	}

	private static int countNoOfLeaf(Node node) {
		if (node != null) {
			int leftLeafCount = countNoOfLeaf(node.getLeft());
			int rightLeafCount = countNoOfLeaf(node.getRight());
			if (node.getLeft() == null && node.getRight() == null) {
				return 1;
			}
			return leftLeafCount + rightLeafCount;

		}
		return 0;
	}

}
