package com.practise;

import java.util.Scanner;

public class UncommonCharacters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		for (int testCase = 0; testCase < noOfTestCases; testCase++) {
			String firstString = sc.next();
			String secondString = sc.next();
			int[] firstCharArr = new int[26];
			for (int firstIndex = 0; firstIndex < firstString.length(); firstIndex++) {
				int codePoint = firstString.charAt(firstIndex);
				firstCharArr[codePoint - 97] = 1;
			}
			//System.out.println(Arrays.toString(firstCharArr));
			int[] secondCharArr = new int[26];
			for (int secondIndex = 0; secondIndex < secondString.length(); secondIndex++) {
				int codePoint = secondString.charAt(secondIndex);
				secondCharArr[codePoint - 97] = 1;
			}
			//System.out.println(Arrays.toString(secondCharArr));
			for (int i = 0; i < firstCharArr.length; i++) {
				if ((secondCharArr[i] == 1 && firstCharArr[i] == 0 )|| (secondCharArr[i] == 0 && firstCharArr[i] == 1 )) {
					char b = (char) (i + 97);
					System.out.print(b);
				}
			}
			System.out.println("");
		}

	}

}
