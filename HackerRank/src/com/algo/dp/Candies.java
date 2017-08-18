package com.algo.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/candies/problem
 * 
 * @author hruday.g
 *
 */
public class Candies {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalNumberOfStudents = sc.nextInt();
		int[] inputArr = new int[totalNumberOfStudents];
		for (int i = 0; i < totalNumberOfStudents; i++) {
			inputArr[i] = sc.nextInt();
		}

		//System.out.println(Arrays.toString(inputArr));

		long ans = findMinCandiesToBuy(inputArr);
		System.out.println(ans);
		sc.close();

	}

	private static long findMinCandiesToBuy(int[] inputArr) {
		long ans = 0;
		long[] candiesArr = new long[inputArr.length];
		// give all the students min of 1 candy
		Arrays.fill(candiesArr, 1);

		// increase the candies to the students who has value greater than the
		// student on his left side
		for (int i = 1; i < inputArr.length; i++) {
			if (inputArr[i] > inputArr[i - 1]) {
				candiesArr[i] = candiesArr[i - 1] + 1;
			}
		}

		// increase the candies if the student is greater than the right student
		for (int i = inputArr.length - 2; i >= 0; i--) {
			if (inputArr[i] > inputArr[i + 1]) {
				candiesArr[i] = Math.max(candiesArr[i], candiesArr[i + 1] + 1);
			}
		}

		for (int i = 0; i < candiesArr.length; i++) {
			ans = ans + candiesArr[i];
		}
		return ans;
	}
}
