package com.practise.array;

public class MajorityElement {
	public static void main(String[] args) {
		int[] input = { 2, 2, 3, 5, 2, 2, 6 };
		int majorityEle = findMajorityElement(input);
		checkIsMajority(input, majorityEle);
	}

	private static void checkIsMajority(int[] input, int majorityEle) {
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == majorityEle) {
				count++;
			}
		}

		if (count > input.length / 2) {
			System.out.println("There exists the majority element " + majorityEle);
		} else {
			System.out.println("No, there doesnot exists the majority element");
		}
	}

	private static int findMajorityElement(int[] input) {
		int majorityIndex = 0;
		int count = 0;
		for (int i = 1; i < input.length; i++) {
			if (input[majorityIndex] == input[i]) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				majorityIndex = i;
				count = 1;
			}
		}
		return input[majorityIndex];
	}
}
