package com.practise.sorting;

import java.util.Arrays;

/**
 * 
 * http://www.geeksforgeeks.org/merge-sort/
 * 
 * @author hruday.g
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] inputArr = { 12, 11, 13, 5, 7, 6 };
		sort(inputArr);
		System.out.println(Arrays.toString(inputArr));
		//int[] testMergeArr = {11, 12, 13, 7, 5, 6};
		//merge(testMergeArr, 0, 3, 5);
		//System.out.println(Arrays.toString(testMergeArr));
	}

	private static void sort(int[] inputArr) {
		mergeSort(inputArr, 0, inputArr.length - 1);
	}

	private static void mergeSort(int[] inputArr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;

			mergeSort(inputArr, start, mid);
			mergeSort(inputArr, mid + 1, end);

			merge(inputArr, start, mid, end);

		}

	}

	private static void merge(int[] inputArr, int start, int mid, int end) {
		int[] leftArr = new int[mid - start + 1] ;

		// mid element will go to the righ sub array
		int[] rightArr = new int[end - mid];

		for (int i = 0; i < leftArr.length; i++) {
			leftArr[i] = inputArr[start + i];
		}

		for (int j = 0; j < rightArr.length; j++) {
			rightArr[j] = inputArr[mid + j + 1];
		}
		
		int leftIndex = 0;
		int rightIndex = 0;
		int inputArrIndex = start;
		while(leftIndex < leftArr.length && rightIndex < rightArr.length){
			if(leftArr[leftIndex] <= rightArr[rightIndex]){
				inputArr[inputArrIndex] = leftArr[leftIndex];
				leftIndex++;
			}else{
				inputArr[inputArrIndex] = rightArr[rightIndex];
				rightIndex++;
			}
			inputArrIndex++;
		}
		
		while(leftIndex < leftArr.length){
			inputArr[inputArrIndex] = leftArr[leftIndex];
			leftIndex++;
			inputArrIndex++;
		}
		
		while(rightIndex < rightArr.length){
			inputArr[inputArrIndex] = rightArr[rightIndex];
			rightIndex++;
			inputArrIndex++;
		}
	}
}
