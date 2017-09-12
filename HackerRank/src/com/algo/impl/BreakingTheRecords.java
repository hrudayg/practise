package com.algo.impl;

import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 * @author hruday.g
 *
 */
public class BreakingTheRecords {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] inputArr = new int[length];
		
		for(int index = 0; index < length; index++){
			inputArr[index] = sc.nextInt();
		}
		
		int most = 0;
		int least = 0;
		int max = inputArr[0];
		int min = inputArr[0];
		for(int i = 1; i < length; i++){
			if(inputArr[i] > max){
				most++;
				max = inputArr[i];
			}
			
			if(inputArr[i] < min){
				least++;
				min = inputArr[i];
			}
		}
		System.out.println(most+" "+least);
		//System.out.println(Arrays.toString(inputArr));
		sc.close();
	}
	

}
