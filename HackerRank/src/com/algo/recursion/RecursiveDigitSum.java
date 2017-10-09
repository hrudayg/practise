package com.algo.recursion;

import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/recursive-digit-sum/problem
 * @author hrudayg
 *
 */
public class RecursiveDigitSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String number = input.split(" ")[0];
		String times = input.split(" ")[1];
		String singleDigitSum = findSuperDigit(number);
		String actualNumber = String.valueOf(Integer.valueOf(singleDigitSum) * Integer.valueOf(times));
		if(actualNumber.length() >= 2) {
			singleDigitSum = findSuperDigit(actualNumber);
		}
		System.out.println(singleDigitSum);
		sc.close();
	}

	private static String findSuperDigit(String number) {
		if(number.length() < 2) {
			return number;
		}
		int sum = 0;
		int index = 0;
		while(index < number.length()) {
			int digit = Integer.valueOf(number.charAt(index)+"");
			sum = sum + digit;
			index++;
		}
		return findSuperDigit(String.valueOf(sum));
	}
}
