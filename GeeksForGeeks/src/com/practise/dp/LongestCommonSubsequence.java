package com.practise.dp;

import java.util.Arrays;

/**
 * 
 * http://www.geeksforgeeks.org/longest-common-subsequence/
 * 
 * @author hruday.g
 *
 */

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String firstString = "AGGTAB";
		String secondString = "GXTXAYB";

		int firstStringLength = firstString.length();
		int secondStringLength = secondString.length();

		int ans = findLCS(firstString, secondString, firstStringLength - 1, secondStringLength - 1);
		System.out.println(ans);

		int dpAns = findLCSDp(firstString, secondString, firstStringLength,
		secondStringLength);
		System.out.println(dpAns);
	}

	private static int findLCSDp(String firstString, String secondString, int firstStringLength,
			int secondStringLength) {
		int[][] dpArray = new int[firstStringLength + 1][secondStringLength + 1];

		for (int firstStringIndex = 1; firstStringIndex < firstStringLength + 1; firstStringIndex++) {
			for (int secondStringIndex = 1; secondStringIndex < secondStringLength + 1; secondStringIndex++) {
				if (firstString.charAt(firstStringIndex - 1) == secondString.charAt(secondStringIndex - 1)) {
					dpArray[firstStringIndex][secondStringIndex] = 1
							+ dpArray[firstStringIndex - 1][secondStringIndex - 1];
				} else {
					dpArray[firstStringIndex][secondStringIndex] = Math.max(
							dpArray[firstStringIndex - 1][secondStringIndex],
							dpArray[firstStringIndex][secondStringIndex - 1]);
				}
			}
		}
		//printDpArray(dpArray);
		return dpArray[firstStringLength][secondStringLength];
	}

	private static void printDpArray(int[][] dpArray) {
		for(int i = 0; i < dpArray.length; i++){
			System.out.println(Arrays.toString(dpArray[i]));
		}
	}

	private static int findLCS(String firstString, String secondString, int firstStringIndex, int secondStringIndex) {

		if (firstStringIndex < 0 || secondStringIndex < 0) {
			return 0;
		}

		int length = 0;

		if (firstString.charAt(firstStringIndex) == secondString.charAt(secondStringIndex)) {
			length = 1 + findLCS(firstString, secondString, firstStringIndex - 1, secondStringIndex - 1);
		} else {
			int firstChoice = findLCS(firstString, secondString, firstStringIndex - 1, secondStringIndex);
			int secondChoice = findLCS(firstString, secondString, firstStringIndex, secondStringIndex - 1);
			length = length + Math.max(firstChoice, secondChoice);
		}

		return length;
	}
}
