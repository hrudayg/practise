package com.algo.impl;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/almost-sorted/problem
 * @author hruday.g
 *
 */
public class AlmostSorted {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] inputArr = new int[length];
		inputArr[0] = sc.nextInt();
		if (length < 2) {
			System.out.println("yes");
		}
		int startIndex = -1;
		int endIndex = -1;
		for (int i = 1; i < length; i++) {
			inputArr[i] = sc.nextInt();
			if (startIndex == -1 && inputArr[i - 1] > inputArr[i]) {
				startIndex = i - 1;
			}
		}
		//System.out.println(Arrays.toString(inputArr));
		//System.out.println("startIndex is : " + startIndex);

		for (int i = length - 2; i >= 0; i--) {
			if (endIndex == -1 && inputArr[i + 1] < inputArr[i]) {
				endIndex = i + 1;
			}
		}

		//System.out.println("endIndex is :" + endIndex);
		if (startIndex == -1 && endIndex == -1) {
			System.out.println("yes");
		}

		swap(inputArr, startIndex, endIndex);
		boolean isSorted = checkIfSorted(inputArr);
		//System.out.println("isSorted After swapping is :" + isSorted);
		if (isSorted) {
			System.out.println("yes");
			System.out.println("swap"+" "+(startIndex + 1)+" "+(endIndex + 1));
			sc.close();
			return;
		}
		reverse(inputArr, startIndex + 1, endIndex - 1);
		isSorted = checkIfSorted(inputArr);
		if (isSorted) {
			System.out.println("yes");
			System.out.println("reverse"+" "+(startIndex + 1)+" "+(endIndex + 1));
			sc.close();
			return;
		}
		System.out.println("no");
		sc.close();
	}

	private static void reverse(int[] inputArr, int startIndex, int endIndex) {
		//System.out.println("reversing the array between startIndex " + startIndex + " and endIndex : " + endIndex);
		while (startIndex > 0 && endIndex < inputArr.length && startIndex < endIndex) {
			int temp = inputArr[startIndex];
			inputArr[startIndex] = inputArr[endIndex];
			inputArr[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
		//System.out.println(Arrays.toString(inputArr));
	}

	private static boolean checkIfSorted(int[] inputArr) {
		boolean isSorted = true;
		for (int i = 0; i < inputArr.length - 1; i++) {
			if (inputArr[i + 1] < inputArr[i]) {
				isSorted = false;
			}
		}

		return isSorted;
	}

	private static void swap(int[] inputArr, int startIndex, int endIndex) {
		//System.out.println("swapping startindex " + startIndex + " and endIndex " + endIndex);
		int temp = inputArr[startIndex];
		inputArr[startIndex] = inputArr[endIndex];
		inputArr[endIndex] = temp;

		//System.out.println(Arrays.toString(inputArr));
		//System.out.println("******************");
	}

}
