package com.practise.sorting;

import java.util.Arrays;

/**
 * 
 * http://www.geeksforgeeks.org/insertion-sort/
 * @author hruday.g
 *
 */
public class InsertionSort {
	public static void main(String[] args) {
		int[] inputArray = {12, 11, 13, 5, 6};
		sort(inputArray);
		System.out.println(Arrays.toString(inputArray));
	}

	private static void sort(int[] inputArray) {
		for(int i = 1; i < inputArray.length; i++){
			int currentElemment = inputArray[i];
			int j = i - 1;
			
			while(j >= 0 && inputArray[j] > currentElemment){
				inputArray[j + 1] = inputArray[j];
				j--;
			}
			
			inputArray[j + 1] = currentElemment;
		}
	}
}
