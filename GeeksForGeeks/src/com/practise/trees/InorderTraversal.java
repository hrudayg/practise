package com.practise.trees;

import java.util.Stack;

/*
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 */

public class InorderTraversal {

	public static void main(String[] args) {
		Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));
        root.getLeft().getRight().setLeft(new Node(6));
        root.getLeft().getRight().setRight(new Node(7));
        inorderTraversal(root);
		System.out.println();
		inorderTraversalWithOutRecursion(root);

	}

	private static void inorderTraversalWithOutRecursion(Node node) {
		Stack<Node> aStack = new Stack<>();
		
		while (true) {
			
			while (node != null) {
				aStack.push(node);
				node = node.getLeft();
			}

			while (aStack != null && !aStack.isEmpty()) {
				Node popedNode = aStack.pop();
				System.out.print(popedNode.getValue()+" ");
				if (popedNode.getRight() != null) {
					aStack.push(popedNode.getRight());
					node = popedNode.getRight().getLeft();
					break;
				}
			}
			
			if(aStack.isEmpty()){
				break;
			}
			
		}

	}

	private static void inorderTraversal(Node node) {
		if (node != null) {
			inorderTraversal(node.getLeft());
			System.out.print(node.getValue() + " ");
			inorderTraversal(node.getRight());
		}
	}

}
