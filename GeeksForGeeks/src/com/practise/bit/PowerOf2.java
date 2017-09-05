package com.practise.bit;


/**
 * Check if a number is power of 2
 * @author hruday.g
 *
 */
public class PowerOf2 {

	public static void main(String[] args) {
		int number = 64;
		checkIsNumberPowerOf2(number);
	}

	private static void checkIsNumberPowerOf2(int number) {
		int countOfOnes = 0;
		
		while(number > 0){
			if((number & 1) == 1){
				countOfOnes++;
			}
			number = number >> 1;
		}
		
		System.out.println(countOfOnes);
		
		if(countOfOnes == 1){
			System.out.println("It is a power of 2");
		}else{
			System.out.println("Not a power of 2");
		}
	}
}
