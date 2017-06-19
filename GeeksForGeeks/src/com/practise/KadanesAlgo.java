package com.practise;

import java.util.Scanner;

public class KadanesAlgo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		for (int i = 0; i < noOfTestCases; i++) {
			int arrayLength = sc.nextInt();
			int currentMax = sc.nextInt();
			int maxSofar = currentMax;
			arrayLength--;
			while (arrayLength > 0) {
				int number = sc.nextInt();
				currentMax = Math.max(number, currentMax+number);
				maxSofar = Math.max(currentMax, maxSofar);
				arrayLength--;
			}
			System.out.println(maxSofar);
		}
	}

}
