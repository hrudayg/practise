package com.algo.dp;

import java.util.Arrays;
import java.util.Scanner;

import org.omg.CORBA.portable.ValueInputStream;

public class Equal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();

		for (int i = 0; i < noOfTestCases; i++) {
			int lenthOfInput = sc.nextInt();
			int[] cookieArray = new int[lenthOfInput];
			for (int index = 0; index < lenthOfInput; index++) {
				cookieArray[index] = sc.nextInt();
			}

			//System.out.println(Arrays.toString(cookieArray));

			int ans = findCountOfMinIterationsNeeded(cookieArray);
			System.out.println(ans);
		}
	}

	
	/*
	 * 
	 * increasing the each other persons value is same as decreasing that
	 * persons value.
	 * 
	 * For example - Out of 4 people in a competition,3 gets selected
	 * for next round --> 1 person loses. Out of 4 people in a competition,
	 * 1 person loses --> 3 gets selected for next round
	 * 
	 * Actually we should reduce each of the array value to the min or min -
	 * 1 or min - 2 or min - 4 --- till each of the value is greater than 0
	 * min - 5 will again increase the count because it actually adds n to
	 * the result of min where n is the length of the cookie array. so we
	 * will consider only till min - 4
	 * 
	 * so we get an optimal solution when iterating through min to  min -4 
	 * 
	 * To avoid the iteration we can also do the following .
	 * 
	 * Now instead of considering all the iterations from min to min - 4
	 * we can have a base values as 0 , 1, 2 .
	 * 
	 * first we sort the array.
	 * We then start with first value in the cookie array and bring all other vaues to the first value .
	 * 
	 */
	
	
	private static int findCountOfMinIterationsNeeded(int[] cookieArray) {
		int ans = Integer.MAX_VALUE;
		Arrays.sort(cookieArray);
		
		for(int base = 0; base < 3; base++ ){
			int currentAns = 0;
			for(int i = 0; i < cookieArray.length; i++){
				int value = cookieArray[i] - cookieArray[0] + base;
				int noOfFives = value / 5;
				value = value % 5;
				int noOfTwos = value / 2;
				value = value % 2;
				int noOfOnes = value;
				currentAns = currentAns + noOfFives + noOfTwos + noOfOnes;
			}
			
			ans = Math.min(ans, currentAns);
		}
	
		return ans;
		
	}

}
