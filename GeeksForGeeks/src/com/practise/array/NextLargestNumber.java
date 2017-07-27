package com.practise.array;

import java.util.Arrays;
/*
 *	http://practice.geeksforgeeks.org/problems/next-larger-element/0
 * 
 */
public class NextLargestNumber {
	public static void main(String[] args) {
		int[] input = { 11, 13, 21, 3, 100 };
		findNextLargestNumber(input);
	}

	private static void findNextLargestNumber(int[] input) {
		int[] outputArr = new int[input.length];
		int index = input.length - 1;
		int nextGreater = -1;
		outputArr[index] = nextGreater;
		nextGreater = input[index];
		
		for (int i = index - 1; i >= 0; i--) {
			if(input[i + 1] > input[i]){
				outputArr[i] = input[i + 1];
				nextGreater = outputArr[i];
			}else if(nextGreater > input[i]){
				outputArr[i] = nextGreater;
			}else{
				outputArr[i] = -1;
			}
		}
		
		System.out.println(Arrays.toString(outputArr));
	}
}
