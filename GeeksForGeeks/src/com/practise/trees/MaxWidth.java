package com.practise.trees;

import java.util.Arrays;

public class MaxWidth {
	
	public static void main(String[] args) {
		/*
        Constructed bunary tree is:
              1
            /  \
           2    3
          / \    \
         4   5    8
                 / \
                6   7 */
		Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));
        root.getRight().setRight(new Node(8));
        root.getRight().getRight().setLeft(new Node(6));
        root.getRight().getRight().setRight(new Node(7));
        
        int height = heightOfTree(root);
        //System.out.println(height);
        int[] arr = new int[height];
        arr = findMaxWidth(root, 0, arr);
        //System.out.println(Arrays.toString(arr));
        int maxWidth = findMaxOfArr(arr);
        System.out.println(maxWidth);
	}

	private static int findMaxOfArr(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
			}
		}
		return max;
	}

	private static int[] findMaxWidth(Node root, int level, int[] arr) {
		if(root != null){
			arr[level]++;
			findMaxWidth(root.getLeft(), level + 1 , arr);
			findMaxWidth(root.getRight(), level + 1, arr);
		}
		return arr;
	}

	private static int heightOfTree(Node root) {
		if(root != null){
			int leftHeight = heightOfTree(root.getLeft());
			int rightHeight = heightOfTree(root.getRight());
			return Math.max(leftHeight, rightHeight) + 1;
		}
		return 0;
	}

}
