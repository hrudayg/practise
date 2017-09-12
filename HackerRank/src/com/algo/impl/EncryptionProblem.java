package com.algo.impl;

import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/encryption/problem
 * @author hruday.g
 *
 */
public class EncryptionProblem {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		encrypt(input);
		sc.close();
	}

	private static void encrypt(String input) {
		int length = input.length();
		//System.out.println("length is :"+length);
		double squareRoot = Math.floor(Math.sqrt(length));
		//System.out.println(squareRoot);
		double noOfRows = squareRoot;
		double noOfCol = Math.ceil(Math.sqrt(length));
		//System.out.println("rows is :"+noOfRows);
		if(noOfRows * noOfCol < length){
			noOfRows = noOfRows + 1;
		}
		//System.out.println("rows is :"+noOfRows);
		//System.out.println("cols is :"+noOfCol);
		int col = 0;
		StringBuffer sb = new StringBuffer();
		while(col < noOfCol){
			for(double index = col; index < length; index=index+noOfCol){
				sb.append(input.charAt((int)index));
			}
			sb.append(" ");
			col++;
		}
		
		System.out.println(sb.toString());
		
	}
}
