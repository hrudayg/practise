package com.practise.dp;

import java.util.Arrays;

/**
 * 
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 * 
 * @author hruday.g
 *
 */
public class MinCostPath {
	public static void main(String[] args) {
		int[][] inputArr = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		findMinCostPath(inputArr);
	}

	private static void findMinCostPath(int[][] inputArr) {
		int noOfRows = inputArr.length;
		int noOfColumns = inputArr[0].length;
		int[][] dpArr = new int[noOfRows][noOfColumns];
		
		dpArr[0][0] = inputArr[0][0];
		
		for(int i = 1; i < noOfRows; i++){
			dpArr[i][0] = dpArr[i - 1][0] + inputArr[i][0];
		}
		
		for(int j = 1; j < noOfColumns; j++){
			dpArr[0][j] = inputArr[0][j] + dpArr[0][j - 1];
		}
		
		for (int i = 1; i < noOfRows; i++) {
			for (int j = 1; j < noOfColumns; j++) {
				dpArr[i][j] = Math.min(dpArr[i - 1][j - 1], Math.min(dpArr[i - 1][j] , dpArr[i][j - 1])) + inputArr[i][j];
			}
		}
		printDpArray(dpArr);
	}

	private static void printDpArray(int[][] dpArr) {
		for(int i = 0; i < dpArr.length; i++){
			System.out.println(Arrays.toString(dpArr[i]));
		}
	}
}
