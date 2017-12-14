package com.algo.impl;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
 * @author i339211
 *
 */
public class OrganisingContainers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		
		for(int testCase = 0; testCase < noOfTestCases; testCase++) {
			int noOfContainers = sc.nextInt();
			long[] containerSum = new long[noOfContainers]; // no of containers
			long[] typesSum = new long[noOfContainers]; // no of types
			for(int row = 0; row < noOfContainers; row++){
				for(int column = 0; column < noOfContainers; column++) {
					long number = sc.nextLong();
					containerSum[row] = containerSum[row] + number;
					typesSum[column] = typesSum[column] + number; 
				}
			}
			
			Arrays.sort(containerSum);
			Arrays.sort(typesSum);
			boolean isPossible = true;
			for(int i = 0 ; i < noOfContainers; i++) {
				if(containerSum[i] != typesSum[i]) {
					isPossible = false;
					break;
				}
			}
			
			if(isPossible) {
				System.out.println("Possible");
			}else {
				System.out.println("Impossible");
			}
		}
		
		sc.close();
	}
}
