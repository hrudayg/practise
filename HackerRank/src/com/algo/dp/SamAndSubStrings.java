package com.algo.dp;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/sam-and-substrings/problem
 */
public class SamAndSubStrings {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		long ans = findTheSumOfAllSubStrings(input);
		System.out.println(ans);
	}

	private static long findTheSumOfAllSubStrings(String input) {
		int MOD = 1000000007;
		int length = input.length();
		long frequency = 1;
		long ans = 0;
		for(int index = length - 1; index >= 0; index--){
			long number = input.codePointAt(index) - '0';
			ans = (ans + (number * frequency * (index + 1)) ) % MOD;
			frequency = (frequency * 10) + 1;
			frequency = frequency % MOD;
		}
		return ans;
	}

}
