package com.practise.array;
/*
 * http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 * 
 */
public class MaxSumNoTwoElementsAdjacent {
	public static void main(String[] args) {
		int[] input = {5, 5, 10, 100, 10, 5};
		findMaxSumNoTwoElementsAdjacent(input);
	}

	private static void findMaxSumNoTwoElementsAdjacent(int[] input) {
		int includingSum = input[0];
		int excludingSum = 0;
		int previousExcluding = 0;
		
		for(int i = 1; i < input.length; i++){
			excludingSum = Math.max(previousExcluding, includingSum); 
			includingSum = input[i] + previousExcluding;
			previousExcluding = excludingSum;
		}
		
		System.out.println(Math.max(includingSum, excludingSum));
	}
}
