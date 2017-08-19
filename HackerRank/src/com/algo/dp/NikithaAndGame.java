package com.algo.dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/array-splitting/problem
 * @author hruday.g
 *
 */
public class NikithaAndGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int noOfTestCases = sc.nextInt();

		for (int testCase = 0; testCase < noOfTestCases; testCase++) {
			int totalNumbers = sc.nextInt();
			long[] sumArray = new long[totalNumbers + 1];

			for (int index = 1; index <= totalNumbers; index++) {
				sumArray[index] = sc.nextLong() + sumArray[index - 1];
			}
			//System.out.println(Arrays.toString(sumArray));
			
			int score = findMaxPossibleScore(sumArray, 0, 1, totalNumbers);
			System.out.println(score);
		}
		

		sc.close();
	}

	private static int findMaxPossibleScore(long[] sumArray, int start, int current, int end) {
		
		if(start >= current || current >= end){
			return 0;
		}
		
		int score = 0;
		
		if((sumArray[current] - sumArray[start]) == (sumArray[end] - sumArray[current])){
			/*if((long)(current - start) > (long)(end - current)){
				end = current;
				current = start + 1;
			}else{
				start = current;
				current = start + 1;
			}*/
			
			//score = 1 + findMaxPossibleScore(sumArray, start, current, end);
			
			score = 1 + Math.max(findMaxPossibleScore(sumArray, start, start + 1, current), 
					findMaxPossibleScore(sumArray, current, current + 1, end));
		}else{
			score = score + findMaxPossibleScore(sumArray, start, current + 1, end);
		}
		
		return score;
	}
	
	/*
	 * This is the Editorial solution for the problem
	 * 
	 */
	private static int findMaxDivideCount(int[] inputs) {
        int n = inputs.length;
        
        // Return 0 if array can't be partitioned (need at least 2 elements to split)
        if(n < 2) {
            return 0;
        }

        // Initialize rightSum as array sum
        int rightSum = 0;
        for (int i = 0; i < n; i++) {
            rightSum += inputs[i];
        }

        // Determine if array can be partitioned into equal leftSum and rightSum
        int leftSum = 0;
        int partitionIndex = 0;
        boolean isEqual = false;
        do {
            // Deduct each value added to rightSum from leftSum
            leftSum += inputs[partitionIndex];
            rightSum -= inputs[partitionIndex];

            // Check balance (i.e., are the two sums equal yet?)
            if(leftSum == rightSum){
                isEqual = true;
                break;
            }
            
        } while(++partitionIndex < n);
        
        // If sums are not equal, return 0 as current array can't be split into halves with equal sums
        if(!isEqual) {
            return 0;
        }

        // Else she gets 1 point, continue checking the left/right subarrays
        return 1 + Math.max(
                    findMaxDivideCount(Arrays.copyOfRange(inputs, 0, partitionIndex + 1)),       
                    findMaxDivideCount(Arrays.copyOfRange(inputs, partitionIndex + 1, n))
        );
    }
	
	
	/*
	 * This is the third solution using hash set.
	 * This is easier to understand.
	 * logic is : We have to have the total sum of all number to be even to divide it in to 2 equal halfs.
	 * if so then recursively check.
	 * 
	 */
	
	/*
	 * @pSum = the set containing all the number i.e a[o], a[0]+a[1] and so on
	 * @min = 0
	 * @max = total sum i.e summation of a[i]
	 * 
	 */
	public static int findMaxDeepness(Set<Long> pSum, long min, long max){
	    if((max + min) % 2 == 0 && pSum.contains((max + min)/2)){
	        return 1 + Math.max(findMaxDeepness(pSum, min, (max + min)/2), findMaxDeepness(pSum,(max + min)/2, max));
	    } else {  
	        return 0;
	    }

	}
	
	
}
