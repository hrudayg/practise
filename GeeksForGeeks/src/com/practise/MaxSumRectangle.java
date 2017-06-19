package com.practise;

import java.util.Scanner;

public class MaxSumRectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		for (int i = 0; i < noOfTestCases; i++) {
			int noOfRows = sc.nextInt();
			int noOfCol = sc.nextInt();
			int[][] inputArray = new int[noOfRows][noOfCol];
			for (int row = 0; row < noOfRows; row++) {
				for (int col = 0; col < noOfCol; col++) {
					inputArray[row][col] = sc.nextInt();
				}
			}
			// System.out.println(Arrays.deepToString(inputArray));
			findMaxSum(inputArray, noOfRows, noOfCol);
		}
	}

	private static void findMaxSum(int[][] inputArray, int noOfRows, int noOfCols) {

		int globalMaxSoFar = 0;
		int GlobalCurrentSum = 0;
		int maxLeft = 0;
		int maxRigth = 0;
		int maxTop = 0;
		int maxBottom = 0;

		for (int left = 0; left < noOfCols; left++) {
			int[] tempArr = new int[noOfRows];
			for (int right = left; right < noOfCols; right++) {
				tempArr[0] = tempArr[0] + inputArray[0][right];
				int localMaxSoFar = tempArr[0];
				int localCurrentSum = tempArr[0];
				int topIndex = 0;
				int bottomIndex = 0;
				for (int i = 1; i < noOfRows; i++) {
					tempArr[i] = tempArr[i] + inputArray[i][right];
					if (tempArr[i] > localCurrentSum + tempArr[i]) {
						topIndex = i;
						
						localCurrentSum = tempArr[i];
					} else {
						localCurrentSum = tempArr[i] + localCurrentSum;
					}
					if (localCurrentSum > localMaxSoFar) {
						localMaxSoFar = localCurrentSum;
						bottomIndex = i;
						
					}
				}
				//System.out.println(Arrays.toString(tempArr));
				if(localMaxSoFar > globalMaxSoFar){
					maxLeft = left;
					maxRigth = right;
					maxTop = topIndex;
					maxBottom = bottomIndex;
					globalMaxSoFar = localMaxSoFar;
				}
				
			}
		}
		
		System.out.println(globalMaxSoFar);

	}

}
