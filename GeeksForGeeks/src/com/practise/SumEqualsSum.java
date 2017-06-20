package com.practise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SumEqualsSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		//System.out.println(noOfTestCases);
		for (int i = 0; i < noOfTestCases; i++) {
			int result = 0;
			int noOfInputs = sc.nextInt();
			int[] inputArr = new int[noOfInputs];

			for (int index = 0; index < noOfInputs; index++) {
				inputArr[index] = sc.nextInt();
			}
			Set<Integer> sumSet = new HashSet<>();
			for (int first = 0; first < noOfInputs; first++) {
				for (int second = first + 1; second < noOfInputs; second++) {
					if(!sumSet.add(inputArr[first] + inputArr[second])){
						result = 1;
						break;
					}
				}
				if(result == 1){
					break;
				}
			}
			
			System.out.println(result);

		}
	}
}
