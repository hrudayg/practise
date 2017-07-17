package com.practise.array;

import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/
 * 
 */
public class ClosestSumToZero {
	public static void main(String[] args) {
		int[] input = {1, 60, -10, 70, -80, 85};
		
		findSumClosestToZero(input);
	}

	private static void findSumClosestToZero(int[] input) {
		Arrays.sort(input);
		System.out.println(Arrays.toString(input));
		int left = 0;
		int right = input.length - 1;
		int closestSum = Integer.MAX_VALUE;
		while(left < right && left >= 0 && right <= input.length - 1){
			int sum = input[left] + input[right];
			if(sum < 0){
				left++;
				sum = sum * -1;
			}else{
				right++;
			}
			
			closestSum = sum < closestSum ? sum : closestSum;
			System.out.println(closestSum);
		}
	}
}
