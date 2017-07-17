package com.practise.array;

import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
 * 
 */
public class Segregate0n1 {
	public static void main(String[] args) {
		int[] input = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		segregate(input);
	}

	private static void segregate(int[] input) {
		System.out.println(Arrays.toString(input));
		int zeroIndex = 0;
		int oneIndex = input.length - 1;
		
		while(zeroIndex < oneIndex){
			while(input[zeroIndex] == 0){
				zeroIndex++;
			}
			
			while(input[oneIndex] == 1){
				oneIndex--;
			}
			
			input[zeroIndex] = 0;
			input[oneIndex] = 1;
			
			zeroIndex++;
			oneIndex--;
		}
		
		System.out.println(Arrays.toString(input));
	}
}
