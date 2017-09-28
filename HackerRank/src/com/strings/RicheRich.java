package com.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/richie-rich/problem
 * 
 * @author hruday.g
 *
 */
public class RicheRich {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int k = sc.nextInt();
		String input = sc.next();
		//System.out.println(input);
		String palindrome = convertToPalindrome(input, length, k);
		System.out.println(palindrome);
		sc.close();
	}

	private static String convertToPalindrome(String input, int length, int k) {
		int startIndex = 0;
		int endIndex = input.length() - 1;
		int noOfDifferences = 0;
		int maxNoOfChanges = k;
		char[] inputArr = input.toCharArray();
		boolean isAlreadyAPalindrome = false;
		List<Integer> unmatchedList = new ArrayList<>();
		if(input.length() == 1 && maxNoOfChanges > 0){
			return new String("9");
		}
		
		while (startIndex < endIndex) {
			if (inputArr[startIndex] != inputArr[endIndex]) {
				unmatchedList.add(startIndex);
				noOfDifferences++;
			}
			startIndex++;
			endIndex--;
		}
		
		if(noOfDifferences == 0 && maxNoOfChanges > 1){
			isAlreadyAPalindrome = true;
		}
		
		//for an even string if it is a palindrome we need atleast 2 max changes to convert to next larger palindrome.
		if(noOfDifferences == 0 && maxNoOfChanges <= 1 && inputArr.length % 2 == 0){
			return input;
		}
		
		//for an odd length palindrome string we just need to change the middle element to 9.
		if(noOfDifferences == 0 && maxNoOfChanges == 1 && inputArr.length % 2 != 0){
			inputArr[inputArr.length / 2] = '9';
			return new String(inputArr);
		}
		
		
		if(noOfDifferences > maxNoOfChanges){
			return "-1";
		}
		
		startIndex = 0;
		endIndex = input.length() - 1;
		
		while(startIndex < endIndex){
			if(inputArr[startIndex] == inputArr[endIndex]){
				if(inputArr[startIndex] != '9'){
					
					//We are trying to change the both the chars to 9 
					if(noOfDifferences + 2 <= maxNoOfChanges){
						changeTheIndicesTo9(inputArr, startIndex, endIndex);
						maxNoOfChanges = maxNoOfChanges - 2;
					}
					
				}
			}else{
				//either of them is equal to 9
				if(inputArr[startIndex] == '9' || inputArr[endIndex] == '9'){
					if(noOfDifferences - 1 <= maxNoOfChanges - 1 && (noOfDifferences - 1) >= 0 && (maxNoOfChanges - 1) >= 0){
						changeTheIndicesTo9(inputArr, startIndex, endIndex);
						noOfDifferences = noOfDifferences - 1;
						maxNoOfChanges = maxNoOfChanges - 1;
					}
				}else{
					//we are changing both the indices to 9
					if(noOfDifferences - 1 <= maxNoOfChanges - 2 && (noOfDifferences - 1) >= 0 && (maxNoOfChanges - 2) >= 0){
						changeTheIndicesTo9(inputArr, startIndex, endIndex);
						noOfDifferences = noOfDifferences - 1;
						maxNoOfChanges = maxNoOfChanges - 2;
					}else if(noOfDifferences - 1 <= maxNoOfChanges - 1 && (noOfDifferences - 1) >= 0 && (maxNoOfChanges - 1) >= 0){
						changeTheIndicesToMax(inputArr, startIndex, endIndex);
						noOfDifferences = noOfDifferences - 1;
						maxNoOfChanges = maxNoOfChanges - 1;
					}
				}
			}
			
			if(noOfDifferences == 0 && maxNoOfChanges == 0){
				break;
			}
			
			startIndex++;
			endIndex--;
		}
		
		//If the input is odd and noOfChanges are left then change the middle one to 9
		if(noOfDifferences == 0 && maxNoOfChanges > 0 && inputArr.length % 2 == 1){
			inputArr[inputArr.length / 2] = '9';
			maxNoOfChanges = maxNoOfChanges - 1;
		}
		
		if((noOfDifferences == 0 && maxNoOfChanges >= 0) || isAlreadyAPalindrome){
			return new String(inputArr);
		}
		
		return "-1";
	}

	private static void changeTheIndicesToMax(char[] inputArr, int startIndex, int endIndex) {
		char maxChar = inputArr[startIndex] > inputArr[endIndex] ? inputArr[startIndex] : inputArr[endIndex];
		inputArr[startIndex] = maxChar;
		inputArr[endIndex] = maxChar;
	}

	private static void changeTheIndicesTo9(char[] inputArr, int startIndex, int endIndex) {
		inputArr[startIndex] = '9';
		inputArr[endIndex] = '9';
	}
}
