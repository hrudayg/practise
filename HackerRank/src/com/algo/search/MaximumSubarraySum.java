package com.algo.search;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/maximum-subarray-sum/problem
 * 
 * @author hruday.g
 *
 */
public class MaximumSubarraySum {
	
	/*
	 * Best links for the logic explaination :
	 * https://www.quora.com/What-is-the-logic-used-in-the-HackerRank-Maximise-Sum-problem
	 * https://stackoverflow.com/questions/31113993/maximum-subarray-sum-modulo-m
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalNoOfTestCases = sc.nextInt();

		for (int testCase = 0; testCase < totalNoOfTestCases; testCase++) {
			int length = sc.nextInt();
			long number = sc.nextLong();
			long[] prefixSumArr = new long[length];
			TreeSet<Long> treeSet = new TreeSet<>();
			int index = 0;
			long current = sc.nextLong() % number;
			prefixSumArr[index] = current;
			treeSet.add(current);
			index++;
			long maxSoFar = current;
			while (index < length) {
				current = (prefixSumArr[index - 1] + sc.nextLong()) % number;
				prefixSumArr[index] = current;
				long largestNumber = getLargestNumberLessThanCurrent(treeSet, current);
				maxSoFar = Math.max(maxSoFar, (current - largestNumber + number) % number);
				treeSet.add(current);
				index++;
			}

			System.out.println(maxSoFar);
		}

		sc.close();
	}

	private static long getLargestNumberLessThanCurrent(TreeSet<Long> treeSet, long current) {
		Long nextHigher = treeSet.higher(current);
		if(nextHigher != null){
			return nextHigher;
		}
		return 0l;
	}

}
