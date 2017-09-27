package com.algo.impl;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem
 * @author hruday.g
 *
 */
public class BirthdayChocolate {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] input = new int[length];
		for (int i = 0; i < length; i++) {
			input[i] = sc.nextInt();
		}
		int day = sc.nextInt();
		int month = sc.nextInt();
		int noOfSplits = findNoOfSplits(input, day, month);
		System.out.println(noOfSplits);
		sc.close();
	}

	private static int findNoOfSplits(int[] input, int day, int month) {
		int startIndex = 0;
		int endIndex = 0;
		int sum = 0;
		int splits = 0;
		if (month > input.length) {
			return splits;
		}
		while (month > 0) {
			sum = sum + input[endIndex];
			endIndex++;
			month--;
		}
		if (sum == day) {
			splits++;
		}
		while (endIndex < input.length) {
			sum = sum - input[startIndex++] + input[endIndex++];
			if (sum == day) {
				splits++;
			}
		}

		return splits;

	}
}
