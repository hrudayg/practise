package com.practise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SmallestDistinctWindow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		for (int i = 0; i < noOfTestCases; i++) {
			String input = sc.next();
			int minWindow = Integer.MAX_VALUE;
			int length = input.length();
			int firstIndex = 0;
			int secondIndex = 0;
			int[] charArr = new int[256];
			int window = Integer.MAX_VALUE;
			Set<Character> inputSet = new HashSet<>();
			for (int index = 0; index < length; index++) {
				inputSet.add(input.charAt(index));
			}
			int distinctCount = inputSet.size();
			int count = 0;
			while (secondIndex < length) {
				charArr[input.charAt(secondIndex)]++;
				if (charArr[input.charAt(secondIndex)] == 1) {
					count++;
				}

				if (count == distinctCount) {

					while (charArr[input.charAt(firstIndex)] > 1) {
						charArr[input.charAt(firstIndex)]--;
						firstIndex++;
					}

					window = secondIndex - firstIndex + 1;
					minWindow = minWindow < window ? minWindow : window;

				}

				secondIndex++;
			}
			System.out.println(minWindow);
		}

	}

}
>>>>>>> f84ec7f8b33b3631f944f90c450e9db422390e5f
