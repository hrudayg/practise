package com.practise.bit;


/**
 * 
 * http://www.geeksforgeeks.org/smallest-power-of-2-greater-than-or-equal-to-n/
 * @author hruday.g
 *
 */
public class NextPowerOf2 {
	
	public static void main(String[] args) {
		int number = 25;
		int nextPowerOf2 = findNextPowerOf2(number);
		System.out.println(nextPowerOf2);
	}

	public static int findNextPowerOf2(int number) {
		if(number == 0){
			return 1;
		}
		
		if((number & (number - 1)) == 0){
			return number;
		}
		
		
		/*
		 * Try to do an and operation with number -1. Somewhere in the loop it should be zero
		 * This is based on the fact that number which is power of 2 & with number - 1 will be zero.
		 * if so then return number left shifted 1
		 */
		
		while((number & (number - 1)) > 0){
			number = number & (number - 1);
		}
		
		return number << 1;
	}

}
