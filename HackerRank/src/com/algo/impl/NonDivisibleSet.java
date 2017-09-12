package com.algo.impl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 * @author hruday.g
 *
 */
public class NonDivisibleSet {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int k = sc.nextInt();
		int[] remainderArr = new int[k];
		//get the count of all the numbers with particular remainders
		for(int i = 0 ; i < length; i++){
			int number = sc.nextInt();
			int remainder = number % k;
			remainderArr[remainder]++; 
		}
		
		int result = 0;
		
		//we need to get max of j and k - j as we need to pick any one of then to the set.
		for(int remainder = 1; remainder <= k/2; remainder++){
			if(remainder != (k - remainder)){
				result = result + Math.max(remainderArr[remainder], remainderArr[k - remainder]);
			}
		}
		
		//if the k is an even number and if there is any number with the remainder k/2 . we need to add 1 to the result.
		if(k % 2 == 0 && remainderArr[k/2] > 0){
			result++;
		}
		
		
		//again add to the result if there is any number with remainder 0.
		if(remainderArr[0] > 0){
			result++;
		}
		
		//System.out.println(Arrays.toString(remainderArr));
		System.out.println(result);
		sc.close();
	}
	
	
}
