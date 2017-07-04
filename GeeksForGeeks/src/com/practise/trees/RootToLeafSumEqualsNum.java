package com.practise.trees;
/*
 * http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
 * 
 */
public class RootToLeafSumEqualsNum {

	public static void main(String[] args) {
		int[] input = { 10, 8, 2, 3, 5, 2 };
		Node node = null;
		node = TreeUtil.createBinaryTree(node, input, 0);
		System.out.println(node);
		int sum = 23;
		boolean isTreeSatisfies = findRootToLeafSum(node, sum);
		System.out.println(isTreeSatisfies);
	}

	private static boolean findRootToLeafSum(Node node, int sum) {
		if (node != null) {
			sum = sum - node.getValue();
			if (sum == 0 && node.getLeft() == null && node.getRight() == null) {
				return true;
			}
			if (sum < 0) {
				return false;
			}
			boolean ans = false;
			if (node.getLeft() != null) {
				ans = ans || findRootToLeafSum(node.getLeft(), sum);
			}

			if (node.getRight() != null) {
				ans = ans || findRootToLeafSum(node.getRight(), sum);
			}
			
			return ans;
		}
		return sum == 0;
	}

}
