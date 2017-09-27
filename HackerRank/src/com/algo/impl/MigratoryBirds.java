package com.algo.impl;

import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/migratory-birds/problem
 * 
 * @author hruday.g
 *
 */
public class MigratoryBirds {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] input = new int[length];
		for (int i = 0; i < length; i++) {
			input[i] = sc.nextInt();
		}
		int ans = findCommonBird(input);
		System.out.println(ans);
		sc.close();
	}

	private static int findCommonBird(int[] input) {
		int[] resultArr = new int[6];
		for (int i = 0; i < input.length; i++) {
			resultArr[input[i]]++;
		}
		int result = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < resultArr.length; i++) {
			if (resultArr[i] > max) {
				max = resultArr[i];
				result = i;
			}

			if (resultArr[i] == max && result == -1) {
				result = i;
			}
		}
		return result;
	}
}
