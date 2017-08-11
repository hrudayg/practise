package com.algo.dp;

import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int totalCoins = sc.nextInt();

		int[] coinsArr = new int[totalCoins];
		for (int i = 0; i < coinsArr.length; i++) {
			coinsArr[i] = sc.nextInt();
		}

		long ans = getWays(sum, coinsArr, 0);
		ans = getWays(sum, coinsArr);
		System.out.println(ans);
	}

	private static long getWays(int sum, int[] coinsArr) {
		long table[] = new long[sum + 1];
		
		table[0] = 1;
		
		for(int index = 0; index < coinsArr.length; index++){
			for(int j = coinsArr[index]; j <= sum; j++){
				table[j] = table[j] + table[j - coinsArr[index]];
			}
		}
		
		return table[sum];
	}

	private static int getWays(int sum, int[] coinsArr, int index) {
		if (sum < 0 || index >= coinsArr.length) {
			return 0;
		}
		if (sum == 0) {
			return 1;
		}

		//exclude
		int firstSum = getWays(sum, coinsArr, index + 1);
		//include
		int secondSum =	getWays(sum - coinsArr[index], coinsArr, index);
		return firstSum + secondSum;
	}


}
