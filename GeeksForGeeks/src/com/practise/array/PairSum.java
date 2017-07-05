package com.practise.array;

import java.util.HashSet;
import java.util.Set;

public class PairSum {
	public static void main(String[] args) {
		int[] input = { 1, 4, 45, 6, 10, -8 };
		int sum = 48;
		boolean isFound = isPairSumExists(input, sum);
		if(isFound){
			System.out.println("yes");
		}else{
			System.out.println("No");
		}
	}

	private static boolean isPairSumExists(int[] input, int sum) {
		Set<Integer> diffNumbers = new HashSet<>();
		boolean isFound = false;
		for (int i = 0; i < input.length; i++) {
			int diff = sum - input[i];
			if (diffNumbers.contains(diff)) {
				isFound = true;
				break;
			}
			diffNumbers.add(input[i]);
		}
		return isFound;
	}
}
