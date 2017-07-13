package com.practise.trees;

public class KNodes {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.setLeft(new Node(2));
		root.setRight(new Node(3));
		root.getLeft().setLeft(new Node(4));
		root.getLeft().setRight(new Node(5));
		root.getRight().setLeft(new Node(8));
		
		//System.out.println(root);
		
		int dist = 2;
		
		printNodeFromRoot(root, dist);
		
	}

	private static void printNodeFromRoot(Node root, int dist) {
		if(root != null){
			if(dist == 0){
				System.out.println(root.getValue());
			}
			dist--;
			printNodeFromRoot(root.getLeft(), dist);
			printNodeFromRoot(root.getRight(), dist);
			
		}
	}

}
