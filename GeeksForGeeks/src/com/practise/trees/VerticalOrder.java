package com.practise.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrder {
	
	public static void main(String[] args) {
		int[] inputArr = { 20, 18, 2, 3, 15, 20 };
		Node node = null;
		node = TreeUtil.createBinaryTree(node, inputArr, 0);
		System.out.println(node);
		Map<Integer, List<Integer>> aMap = new TreeMap();
		printVerticalOrder(node, 0, aMap);
		System.out.println(aMap);
	}

	private static void printVerticalOrder(Node node, int key, Map<Integer, List<Integer>> aMap) {
		if(node != null){
			List<Integer> aList = aMap.get(key);
			if(aList == null){
				aList = new ArrayList<>();
			}
			aList.add(node.getValue());
			aMap.put(key, aList);
			
			printVerticalOrder(node.getLeft(), key - 1, aMap);
			printVerticalOrder(node.getRight(), key + 1, aMap);
		}
	}

}
