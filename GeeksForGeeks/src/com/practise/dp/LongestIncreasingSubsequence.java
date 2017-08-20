package com.practise.dp;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/longest-increasing-subsequence/
 * @author hruday.g
 *
 */
public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int ans = findLIS(arr);
		System.out.println(ans);
	}

	private static int findLIS(int[] arr) {
		int[] dpArr = new int[arr.length];
		Arrays.fill(dpArr, 1);
		int ans = Integer.MIN_VALUE;
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i]){
					dpArr[i] = Math.max(dpArr[i], (dpArr[j]+1));
					ans = Math.max(dpArr[i], ans);
				}
			}
		}
		return ans;
	}
}
