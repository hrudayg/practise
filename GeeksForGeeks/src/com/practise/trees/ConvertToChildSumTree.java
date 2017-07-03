package com.practise.trees;

public class ConvertToChildSumTree {
	public static void main(String[] args) {
		int[] input = { 50, 7, 2, 3, 5, 1};
		Node root = null;
		root = TreeUtil.createBinaryTree(root, input, 0);
		System.out.println(root);
		convertTreeToChildSum(root);
		System.out.println(root);
	}

	private static Node convertTreeToChildSum(Node node) {
		if (node != null) {
			Node leftNode = convertTreeToChildSum(node.getLeft());
			Node rightNode = convertTreeToChildSum(node.getRight());
			if(leftNode == null && rightNode == null){
				return node;
			}
			int leftNodeValue = leftNode == null ? 0 : leftNode.getValue();
			int rightNodeValue = rightNode == null ? 0 : rightNode.getValue();
			int currentNodeValue = node.getValue();
			if (currentNodeValue < leftNodeValue + rightNodeValue) {
				int diff = leftNodeValue + rightNodeValue - node.getValue();
				currentNodeValue = currentNodeValue + diff;
				node.setValue(currentNodeValue);
			}else if(currentNodeValue > leftNodeValue + rightNodeValue){
				int diff = currentNodeValue - (leftNodeValue + rightNodeValue);
				fixTree(node, leftNode, rightNode, diff);
			}else{
				//do nothing;
			}
			return node;
		}
		return node;
	}

	private static void fixTree(Node node, Node leftNode, Node rightNode, int diff) {
		if(node != null){
			if(leftNode != null){
				node = leftNode;
				leftNode.setValue(leftNode.getValue() + diff);
				rightNode = leftNode.getRight();
				leftNode = leftNode.getLeft();
				if(leftNode == null && rightNode == null){
					return;
				}
				fixTree(node, leftNode, rightNode, diff);
			}else if(rightNode != null){
				node = rightNode;
				rightNode.setValue(rightNode.getValue() + diff);
				leftNode = rightNode.getLeft();
				rightNode = rightNode.getRight();
				if(leftNode == null && rightNode == null){
					return;
				}
				fixTree(node, leftNode, rightNode, diff);
			}
		}
		return;
	}
}
