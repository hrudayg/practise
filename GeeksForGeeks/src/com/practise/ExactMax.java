package com.practise;

import java.util.Scanner;

public class ExactMax {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		for (int i = 0; i < noOfTestCases; i++) {
			String input = sc.next();
			int index = 0;
			int length = input.length();
			int maximumNumber = Integer.MIN_VALUE;
			while (index < length) {
				String numStr = "";
				while (index < length && input.charAt(index) >= 97 && input.charAt(index) <= 123) {
					index++;
				}

				while (index < length && (input.charAt(index) < 97 || input.charAt(index) > 123)) {
					numStr = numStr + input.charAt(index);
					index++;
				}
				if (numStr.length() > 0) {
					Integer convertedNum = new Integer(numStr);
					// System.out.println(convertedNum);
					maximumNumber = maximumNumber > convertedNum ? maximumNumber : convertedNum;
				}
			}
			System.out.println(maximumNumber);
		}
		
	}

}
