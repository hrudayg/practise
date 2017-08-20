package com.practise.dp;

import java.util.Arrays;

/**
 * 
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 * 
 * @author hruday.g
 *
 */
public class RodCutting {

	public static void main(String[] args) {
		int costArr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int price = findMaxSum(costArr, 8);
		int priceFromDp = findMaxSumDp(costArr);
		System.out.println(priceFromDp);
	}

	private static int findMaxSumDp(int[] costArr) {
		int[] dpArr = new int[costArr.length + 1];

		for (int i = 1; i <= costArr.length; i++) {
			for (int j = 0; j < i; j++) {
				dpArr[i] = Math.max(dpArr[i], costArr[j] + dpArr[i - j - 1]);
			}
		}

		System.out.println(Arrays.toString(dpArr));

		return dpArr[costArr.length];
	}

	private static int findMaxSum(int[] costArr, int length) {

		if (length <= 0) {
			return 0;
		}

		int price = Integer.MIN_VALUE;

		for (int i = 0; i < length; i++) {
			price = Math.max(price, (costArr[i] + findMaxSum(costArr, length - 1 - i)));
		}

		return price;
	}

}
