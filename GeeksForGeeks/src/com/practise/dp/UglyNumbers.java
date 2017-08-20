package com.practise.dp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * http://www.geeksforgeeks.org/ugly-numbers/
 * 
 * @author hruday.g
 */
public class UglyNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nthUglyNumber = sc.nextInt();
		int ans = findNthUglyNumber(nthUglyNumber);
		System.out.println(ans);
		sc.close();
	}

	private static int findNthUglyNumber(int nthUglyNumber) {
		int twoIndex = 0;
		int threeIndex = 0;
		int fifthIndex = 0;
		
		ArrayList<Integer> uglyNumberList = new ArrayList<>();
		uglyNumberList.add(1);
		
		int count = 1;
		
		while(count < nthUglyNumber){
			int mulBy2 = uglyNumberList.get(twoIndex) * 2;
			int mulBy3 = uglyNumberList.get(threeIndex) * 3;
			int mulBy5 = uglyNumberList.get(fifthIndex) * 5;
			
			int min = Math.min(mulBy2, Math.min(mulBy3, mulBy5));
			uglyNumberList.add(min);
			
			if(min == mulBy2){
				twoIndex++;
			}
			
			if(min == mulBy3){
				threeIndex++;
			}
			
			if(min == mulBy5){
				fifthIndex++;
			}
			
			count++;
		}
		
		//System.out.println(uglyNumberList);
		return uglyNumberList.get(nthUglyNumber - 1);
		
	}
}
