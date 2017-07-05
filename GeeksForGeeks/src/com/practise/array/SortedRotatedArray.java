package com.practise.array;
/*
 * 
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class SortedRotatedArray {

	public static void main(String[] args) {
		int[] input = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int key = 9;
		int index = findIndexInSortedRotatedArray(input, key);
		System.out.println("index is : "+index);
	}

	private static int findIndexInSortedRotatedArray(int[] input, int key) {
		int pivot = findPivot(input, 0, input.length - 1);
		System.out.println(pivot);
		if (pivot == -1) {
			return binarySearch(input, 0, input.length - 1, key);
		}

		if (input[0] <= key)
			return binarySearch(input, 0, pivot - 1, key);
		return binarySearch(input, pivot + 1, input.length - 1, key);
	}

	private static int binarySearch(int[] input, int start, int end, int key) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;

		if (key == input[mid]) {
			return mid;
		}
		if (key > input[mid]) {
			return binarySearch(input, mid, end, key);
		}

		return binarySearch(input, start, mid, key);
	}

	private static int findPivot(int[] input, int start, int end) {
		if (start > end) {
			return -1;
		}

		if (start == end) {
			return start;
		}

		int mid = (start + end) / 2;

		if (mid < end && input[mid] > input[mid + 1]) {
			return mid + 1;
		}

		if (mid > start && input[mid] < input[mid - 1]) {
			return mid;
		}

		if (input[start] >= input[mid]) {
			return findPivot(input, start, mid - 1);
		}

		return findPivot(input, mid + 1, end);

	}

}
