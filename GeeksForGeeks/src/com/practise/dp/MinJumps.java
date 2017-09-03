package com.practise.dp;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * 
 * @author hruday.g
 *
 */
public class MinJumps {
	public static void main(String[] args) {
		int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
		int minJumps = findMinJumps(arr, 0, arr.length - 1);
		System.out.println(minJumps);
		
		int ans = findMinJumpsDp(arr);
		System.out.println(ans);
	}

	private static int findMinJumpsDp(int[] arr) {
		int[] dpArr = new int[arr.length];
		Arrays.fill(dpArr, Integer.MAX_VALUE);
		dpArr[0] = 0;
		for(int index = 0; index < dpArr.length; index++){
			int noOfSteps = arr[index];
			for(int step = index + 1; step <= (index + noOfSteps) && step < arr.length; step++ ){
				dpArr[step]  = Math.min(dpArr[step], dpArr[index] + 1);
			}
		}
		
		return dpArr[arr.length - 1];
		
	}

	public static int findMinJumps(int arr[], int l, int h)
	{
	   // Base case: when source and destination are same
	   if (h == l)
	     return 0;
	 
	   // When nothing is reachable from the given source
	   if (arr[l] == 0)
	     return Integer.MAX_VALUE;
	 
	   // Traverse through all the points reachable from arr[l]. Recursively
	   // get the minimum number of jumps needed to reach arr[h] from these
	   // reachable points.
	   int min = Integer.MAX_VALUE;
	   for (int i = l+1; i <= h && i <= l + arr[l]; i++)
	   {
	       int jumps = findMinJumps(arr, i, h);
	       if(jumps != Integer.MAX_VALUE && jumps + 1 < min)
	           min = jumps + 1;
	   }
	 
	   return min;
	}
}
