package com.ds.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/2d-array/problem
 * @author hruday.g
 *
 */
public class TwoDArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] inputArr = new int[6][6];
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				inputArr[i][j] = sc.nextInt();
			}
		}
		
		int row = 0;
		int column = 0;
		int sum = 0;
		int max = Integer.MIN_VALUE;
		while(row + 2 <= 5){
			column = 0;
			while(column + 2 <= 5){
				int firstRowSum = inputArr[row][column] + inputArr[row][column + 1] + inputArr[row][column + 2];
				int thirdRowSum = inputArr[row + 2][column] + inputArr[row + 2][column + 1] + inputArr[row + 2][column + 2];
				int middleSum = inputArr[row + 1][column + 1];
				sum = firstRowSum + thirdRowSum + middleSum;
				max = sum > max ? sum : max;
				column++;
			}
			row++;
		}
		
		System.out.println(max);
		
		sc.close();
	}
	
}
