package com.practise.array;
/*
 * http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 */
public class MaxDiff2Elemens {

	public static void main(String[] args) {
		 int arr[] = {80, 2, 6, 3, 100};
		 findMaxDiffBetweenTwoElements(arr);
	}

	private static void findMaxDiffBetweenTwoElements(int[] arr) {
		int minElement = arr[0];
		int maxDiff = Integer.MIN_VALUE;
		
		for(int i = 1; i < arr.length; i++){
			int diff = arr[i] - minElement;
			maxDiff = diff > maxDiff ? diff : maxDiff;
			minElement = arr[i] < minElement ? arr[i] : minElement;
		}
		
		System.out.println(maxDiff);
	}

}
