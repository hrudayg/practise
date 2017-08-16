package com.algo.dp;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/sherlock-and-cost/problem
 */

public class SherlockAndCost {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();

		for (int testCase = 0; testCase < noOfTestCases; testCase++) {
			int totalNumberOfNumbers = sc.nextInt();
			int[] inputArr = new int[totalNumberOfNumbers];
			for (int i = 0; i < totalNumberOfNumbers; i++) {
				inputArr[i] = sc.nextInt();
			}
			// System.out.println(Arrays.toString(inputArr));

			// int ans = findSherlockCostRecursive(inputArr);
			int ans = findSherlockCostDp(inputArr);
			System.out.println(ans);
		}

	}

	private static int findSherlockCostDp(int[] inputArr) {
		int length = inputArr.length;
		int[][] dpArr = new int[2][length];
		for (int index = 1; index < length; index++) {
			int firstValue = dpArr[0][index - 1];
			int secondValue = dpArr[1][index - 1] + Math.abs(1 - inputArr[index - 1]);
			
			dpArr[0][index] = Math.max(firstValue, secondValue);
			
			int thirdValue = dpArr[0][index - 1] + Math.abs(1 - inputArr[index]);
			int fourthValue = dpArr[1][index - 1] + Math.abs(inputArr[index] - inputArr[index - 1]);
			
			dpArr[1][index] = Math.max(thirdValue, fourthValue);
			
		}
		return Math.max(dpArr[0][length - 1], dpArr[1][length - 1]);
	}

	private static int findSherlockCostRecursive(int[] inputArr) {
		int first = findSherlockCost(inputArr, 1, 1, 0);
		int second = findSherlockCost(inputArr, inputArr[0], 1, 0);
		return Math.max(first, second);
	}

	private static int findSherlockCost(int[] inputArr, int previous, int index, int sum) {
		/*
		 * There can be only 2 possibilities for the number Ai i.e 1 or Bi.
		 * 
		 */

		if (index >= inputArr.length) {
			return sum;
		}

		int firstSum = sum + Math.abs(inputArr[index] - previous);
		int secondSum = sum + Math.abs(1 - previous);
		int onePossibility = findSherlockCost(inputArr, inputArr[index], index + 1, firstSum);
		int secondPossibility = findSherlockCost(inputArr, 1, index + 1, secondSum);

		return Math.max(onePossibility, secondPossibility);

	}
}
