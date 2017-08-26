package com.practise.sorting;

import java.util.Arrays;
/**
 * 
 * http://www.geeksforgeeks.org/pancake-sorting/
 * @author hruday.g
 *
 */
public class PancakeSorting {

	public static void main(String[] args) {
		int[] inputArr = { 23, 10, 20, 11, 12, 6, 7 };
		System.out.println("input Array is :"+Arrays.toString(inputArr));
		sort(inputArr);
		System.out.println("sorted Array is :"+Arrays.toString(inputArr));
	}

	private static void sort(int[] inputArr) {
		int length = inputArr.length - 1;

		for (int startIndex = 0; startIndex <= length; startIndex++) {
			int maxIndex = findMaxElementIndex(inputArr, length - startIndex);
			flipArray(inputArr, maxIndex);
			flipArray(inputArr, (length - startIndex));
		}

	}

	private static void flipArray(int[] inputArr, int maxIndex) {
		int start = 0;
		int end = maxIndex;

		while (start < end) {
			int temp = inputArr[start];
			inputArr[start] = inputArr[end];
			inputArr[end] = temp;

			start++;
			end--;
		}
	}

	private static int findMaxElementIndex(int[] inputArr, int endIndex) {
		int index = -1;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= endIndex; i++) {
			if (inputArr[i] > max) {
				max = inputArr[i];
				index = i;
			}
		}

		return index;
	}

}
