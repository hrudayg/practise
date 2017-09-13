package com.algo.warm;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 * @author hruday.g
 *
 */
public class BirthdayCandles {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalCandles = sc.nextInt();
		HashMap<Long, Integer> heightCountMap = new HashMap<>();
		long max = Long.MIN_VALUE;
		for(int i = 0; i < totalCandles; i++){
			long height = sc.nextLong();
			if(height > max){
				max = height;
			}
			if(heightCountMap.get(height) == null){
				heightCountMap.put(height, 1);
			}else{
				int count = heightCountMap.get(height);
				heightCountMap.put(height, count+1);
			}
		}
		
		int ans = heightCountMap.get(max);
		System.out.println(ans);
		sc.close();
	}

}
