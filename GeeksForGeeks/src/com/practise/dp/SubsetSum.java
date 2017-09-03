package com.practise.dp;


/**
 * 
 * 
 * @author hruday.g
 *http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 */
public class SubsetSum {
	public static void main(String[] args) {
		int[] set = { 3, 34, 4, 12, 5, 2 };
		int sum = 37;

		// boolean ans = findIsSubsetSum(set, sum);
		// System.out.println(ans);

		// dp programming
		boolean ans = isSubsetSum(set, set.length, sum);
		System.out.println(ans);
	}

	private static boolean findIsSubsetSum(int[] set, int sum) {
		return findIsSubsetSum(set, sum, set.length - 1);
	}

	private static boolean findIsSubsetSum(int[] set, int sum, int index) {
		if (sum < 0) {
			return false;
		}

		if (sum == 0) {
			return true;
		}

		if (index < 0) {
			return false;
		}

		if (set[index] > sum) {
			return findIsSubsetSum(set, sum, index - 1);
		} else {
			return findIsSubsetSum(set, sum - set[index], index - 1) || findIsSubsetSum(set, sum, index - 1);
		}
	}

	public static boolean isSubsetSum(int set[], int n, int sum) {
		// The value of subset[i][j] will be true if there
		// is a subset of set[0..j-1] with sum equal to i
		boolean subset[][] = new boolean[sum + 1][n + 1];

		// If sum is 0, then answer is true
		for (int i = 0; i <= n; i++)
			subset[0][i] = true;

		// If sum is not 0 and set is empty, then answer is false
		for (int i = 1; i <= sum; i++)
			subset[i][0] = false;

		// Fill the subset table in botton up manner
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];
				if (i >= set[j - 1])
					subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
			}
		}

		/*
		 * // uncomment this code to print table for (int i = 0; i <= sum; i++)
		 * { for (int j = 0; j <= n; j++) printf ("%4d", subset[i][j]);
		 * printf("n"); }
		 */

		return subset[sum][n];
	}
}
