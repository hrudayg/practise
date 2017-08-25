package com.practise.sorting;

import java.util.Arrays;

/**
 * 
 * http://www.geeksforgeeks.org/bubble-sort/
 * 
 * @author hruday.g
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] inputArray = { 12, 11, 13, 5, 6 };
		sort(inputArray);
		System.out.println(Arrays.toString(inputArray));
	}

	private static void sort(int[] inputArray) {
		while (true) {
			boolean isSwapped = false;
			for (int i = 0; i < inputArray.length - 1; i++) {
				int j = i + 1;
				if (inputArray[i] > inputArray[j]) {
					int temp = inputArray[i];
					inputArray[i] = inputArray[j];
					inputArray[j] = temp;
					isSwapped = true;
				}

			}
			if (!isSwapped) {
				System.out.println("sorted");
				break;
			}
		}
	}

}
