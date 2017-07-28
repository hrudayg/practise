package com.practise.hackerrank.strings;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/separate-the-numbers
 * 
 * 
 */
public class SeparateTheNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		for (int testCase = 0; testCase < noOfTestCases; testCase++) {
			String number = sc.next();
			SeparateTheNumbers(number);
		}
	}

	private static void SeparateTheNumbers(String number) {
		boolean valid = false;
		long firstNumber = -1;
		long resultNumber = -1;
		for(int i = 1; i <=number.length()/2; i++){
			StringBuffer first = new StringBuffer(number.substring(0, i));
			firstNumber = Long.parseLong(first.toString());
			resultNumber = firstNumber;
			while(first.length() < number.length()){
				first = first.append(++firstNumber);
			}
			
			if(first.toString().equals(number)){
				valid = true;
				break;
			}
		}
		
		String result = valid ? "YES "+resultNumber : "NO";
		System.out.println(result);
	}
}
