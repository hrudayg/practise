package com.algo.impl;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFact {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		BigInteger ans = findLongFact(number);
		System.out.println(ans);
		sc.close();
	}

	private static BigInteger findLongFact(int number) {
		BigInteger result = BigInteger.ONE;
		while (number > 0) {
			result = result.multiply(new BigInteger(String.valueOf(number)));
			number--;
		}
		return result;
	}

}
