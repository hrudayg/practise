package com.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniqueDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();

		for (int i = 0; i < noOfTestCases; i++) {
			int firstNumber = sc.nextInt();
			int secondNumber = sc.nextInt();
			//System.out.println(firstNumber);
			//System.out.println(secondNumber);
			findUniqueNumbers(firstNumber, secondNumber);
		}

	}

	private static void findUniqueNumbers(int firstNumber, int secondNumber) {
		for (int number = firstNumber; number <= secondNumber; number++) {
			int[] array = new int[10];
			boolean isFound = false;
			int tempNumber = number;
			while (tempNumber > 0) {
				int n = tempNumber % 10;
				if (array[n] == 1) {
					isFound = true;
					break;
				}
				tempNumber = tempNumber / 10;
				array[n] = 1;
			}

			if (!isFound) {
				System.out.print(number+" ");
			}

		}
		System.out.println();
	}

}
