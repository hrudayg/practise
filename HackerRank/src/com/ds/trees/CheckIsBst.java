package com.ds.trees;

/**
 * 
 * https://www.hackerrank.com/challenges/is-binary-search-tree/problem
 * @author hruday.g
 *
 */
public class CheckIsBst {
	
	public static void main(String[] args) {
		
	}
	
	public boolean checkBST(Node root){
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean checkBST(Node node, int minValue, int maxValue) {
		/* an empty tree is BST */
        if (node == null)
            return true;
 
        /* false if this node violates the min/max constraints */
        if (node.data < minValue || node.data > maxValue)
            return false;
 
        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (checkBST(node.left, minValue, node.data-1) &&
        		checkBST(node.right, node.data+1, maxValue));
	}

}
