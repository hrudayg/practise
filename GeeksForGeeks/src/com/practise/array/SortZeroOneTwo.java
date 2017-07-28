package com.practise.array;

import java.util.Arrays;


/*
 * 
 * http://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s/0
 * 
 */
public class SortZeroOneTwo {

	public static void main(String[] args) {
		int[] input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		sortZeroOneTwo(input);
	}

	private static void sortZeroOneTwo(int[] input) {
		int start = 0;
		int mid = start + 1;
		int end = input.length - 1;
		int temp = 0;
		while (mid < end) {
			switch (input[mid]) {
			case 0:
				temp = input[start];
				input[start] = input[mid];
				input[mid] = temp;
				mid++;
				start++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = input[mid];
				input[mid] = input[end];
				input[end] = temp;
				end--;
				break;
			}
		}
		System.out.println(Arrays.toString(input));
	}
}
