package com.practise;

import java.util.Arrays;
import java.util.Scanner;

public class UnsortedArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();

		for (int testCase = 0; testCase < noOfTestCases; testCase++) {
			int length = sc.nextInt();
			int[] inputArr = new int[length];
			int[] leftMax = new int[length];
			int[] rightMin = new int[length];

			leftMax[0] = sc.nextInt();
			inputArr[0] = leftMax[0];

			for (int i = 1; i < length; i++) {
				int input = sc.nextInt();
				inputArr[i] = input;
				leftMax[i] = Math.max(leftMax[i - 1], input);
			}

			rightMin[length - 1] = inputArr[length - 1];

			for (int lastIndex = length - 2; lastIndex >= 0; lastIndex--) {
				rightMin[lastIndex] = Math.min(inputArr[lastIndex], rightMin[lastIndex + 1]);
			}

			/*System.out.println(Arrays.toString(inputArr));
			System.out.println(Arrays.toString(leftMax));
			System.out.println(Arrays.toString(rightMin));*/

			String ans = "-1";
			int index = 0;
			for (index = 1; index < length - 1; index++) {
				if (inputArr[index] >= leftMax[index] && inputArr[index] <= rightMin[index]) {
					ans = String.valueOf(inputArr[index]);
					break;
				}
			}

			/*if (ans.equals(String.valueOf(inputArr[length - 1])) || ans.equals(String.valueOf(inputArr[0]))) {
				System.out.println("-1");
			} else {
				System.out.println(ans);
			}*/
			
			System.out.println(ans);

		}
	}

}
