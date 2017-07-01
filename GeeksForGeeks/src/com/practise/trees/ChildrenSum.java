package com.practise.trees;

public class ChildrenSum {
	public static void main(String[] args) {
		int[] inputArr = { 20, 18, 2, 3, 15, 2 };
		Node node = null;
		node = TreeUtil.createBinaryTree(node, inputArr, 0);
		boolean isSumSatisfied = isTreeSatisfiesChildrenSum(node);
		System.out.println(isSumSatisfied);
	}

	private static boolean isTreeSatisfiesChildrenSum(Node node) {
		if (node != null) {
			boolean isLeftTreeSatisfies = isTreeSatisfiesChildrenSum(node.getLeft());
			boolean isRightTreeSatisfies = isTreeSatisfiesChildrenSum(node.getRight());
			int leftValue = node.getLeft() == null ? 0 : node.getLeft().getValue();
			int rightValue = node.getRight() == null ? 0 : node.getRight().getValue();
			if (node.getLeft() == null && node.getRight() == null) {
				return isLeftTreeSatisfies && isRightTreeSatisfies;
			}
			return isLeftTreeSatisfies && isRightTreeSatisfies && (node.getValue() == leftValue + rightValue);
		}
		return true;
	}
}
