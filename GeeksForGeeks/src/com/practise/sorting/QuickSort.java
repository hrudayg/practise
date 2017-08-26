package com.practise.sorting;

import java.util.Arrays;

/**
 * 
 * http://www.geeksforgeeks.org/quick-sort/
 * 
 * @author hruday.g
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] inputArr = { 10, 80, 30, 90, 40, 50, 70 };
		sort(inputArr);
	}

	private static void sort(int[] inputArr) {
		int start = 0;
		int end = inputArr.length - 1;
		sort(inputArr, start, end);
		System.out.println("sorted Array is " + Arrays.toString(inputArr));
	}

	private static void sort(int[] inputArr, int start, int end) {
		if (start >= end) {
			return;
		}

		int pivot = inputArr[end];
		int partition = partition(inputArr, start, end, pivot);
		sort(inputArr, start, partition - 1);
		sort(inputArr, partition + 1, end);
	}

	private static int partition(int[] inputArr, int start, int end, int pivot) {
		int leftIndex = start - 1;
		int rightIndex = end;
		while (true) {
			while (leftIndex < end && inputArr[++leftIndex] < pivot)
				;

			while (rightIndex > 0 && inputArr[--rightIndex] > pivot)
				;

			if (leftIndex < rightIndex) {
				swap(inputArr, leftIndex, rightIndex);
			} else {
				break;
			}
		}
		swap(inputArr, leftIndex, end);
		return leftIndex;
	}

	private static void swap(int[] inputArr, int leftIndex, int rightIndex) {
		int temp = inputArr[leftIndex];
		inputArr[leftIndex] = inputArr[rightIndex];
		inputArr[rightIndex] = temp;
	}

}
