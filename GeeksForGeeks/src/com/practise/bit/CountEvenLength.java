package com.practise.bit;


/*
 * http://practice.geeksforgeeks.org/problems/count-even-length/0
 *
 */
public class CountEvenLength {
	
	public static void main(String[] args) {
		int n = 2;
		countEvenLength(2 * n);
	}

	private static void countEvenLength(int length) {
		StringBuffer sb = new StringBuffer("");
		findAllCombinations(sb.toString(), length);
	}

	private static void findAllCombinations(String result, int length) {
		
		if(result.length() > length){
			return;
		}
		
		if(result.length() == length){
			
			String firstHalf = result.substring(0, length/2);
			String secondHalf = result.substring(length / 2);
			
			int firstSum = 0;
			int secondSum = 0;
			
			for(int index = 0; index < length/2; index++){
				firstSum = firstSum + Integer.parseInt(""+firstHalf.charAt(index));
			}
			
			for(int index = 0; index < length/2; index++){
				secondSum = secondSum + Integer.parseInt(""+secondHalf.charAt(index));
			}
			
			if(firstSum == secondSum){
				System.out.println(result);
			}
		}
		
		String first = result+"0";
		String second = result+"1";
		
		findAllCombinations(first, length);
		findAllCombinations(second, length);
	}

}
