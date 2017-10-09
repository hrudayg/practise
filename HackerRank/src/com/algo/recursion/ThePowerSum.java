package com.algo.recursion;

import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/the-power-sum/problem
 * @author hrudayg
 *
 */
public class ThePowerSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = sc.nextInt();
		int power = sc.nextInt();
		int ans = findTotalWays(result, power, 1);
		System.out.println(ans);
		sc.close();
	}

	/*
	 * The logic is to take one number or dont take that number .
	 * Proceed with the logic.
	 * 
	 */
	private static int findTotalWays(double result, int power, int number) {
		double value = result - Math.pow(number, power);
		if(value == 0) {
			return 1;
		}
		if(value < 0) {
			return 0;
		}
		// first is if the number is taken + if the number is not taken
		return findTotalWays(value, power, number + 1) + findTotalWays(result, power, number + 1);
		
		
	}

	
}
