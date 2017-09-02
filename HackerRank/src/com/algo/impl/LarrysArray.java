package com.algo.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/larrys-array
 * 
 * @author hruday.g
 *
 */

/*
 * imp to read : https://en.wikipedia.org/wiki/Parity_of_a_permutation
 * http://www.geeksforgeeks.org/check-instance-15-puzzle-solvable/
 * 
 */
public class LarrysArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		for (int testCase = 0; testCase < noOfTestCases; testCase++) {
			int length = sc.nextInt();
			int[] inputArr = new int[length];
			int[] inversionsArr = new int[length];
			int sum = 0;
			for (int index = 0; index < length; index++) {
				inputArr[index] = sc.nextInt();
				for(int i = 0; i < index ; i++){
					if(inputArr[i] > inputArr[index]){
						inversionsArr[index]++; 
					}
				}
				sum = sum + inversionsArr[index];
			}
			
			//System.out.println(Arrays.toString(inversionsArr));
			//System.out.println(sum);
			if(sum % 2 == 0){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
		
		sc.close();
	}

	
}
