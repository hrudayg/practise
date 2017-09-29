package com.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * https://www.hackerrank.com/challenges/two-characters/problem
 * @author hruday.g
 *
 */
public class TwoChars {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		String input = sc.next();
		char[] inputArr = input.toCharArray();
		List<Character> uniqueChars = getCountOfUniqueChars(inputArr);
		int ans = findAlt2Chars(inputArr, uniqueChars);
		System.out.println(ans);
		sc.close();
	}
	
	/*
	 * The logic is to create 2 2d arrays. first to store the chars and second to store the counts.
	 * When ever u find a char in the input , u change the corresponding row and column in both the 2d arrays.
	 * The logic to change the first 2d array is if you find any char other than the investigating char ch and the corresponding count arr is not -1 then u 
	 * update the array to the char and also the count arr to +1.
	 * The reason for checking for countArr != -1 is to handle "aab" types of cases.
	 * 
	 */

	private static int findAlt2Chars(char[] inputArr, List<Character> uniqueChars) {
		int length = uniqueChars.size();
		char[][] charInterSectionArr = new char[length][length];
		int[][] countArr = new int[length][length];
		
		for(int index = 0; index < inputArr.length; index++){
			char ch = inputArr[index];
			int indexInSortedUniqueArr = uniqueChars.indexOf(ch);
			
			for(int i = 0; i < length; i++){
				//change all the rows of that char ch
				if(charInterSectionArr[indexInSortedUniqueArr][i] != ch && countArr[indexInSortedUniqueArr][i] != -1){
					charInterSectionArr[indexInSortedUniqueArr][i] = ch;
					countArr[indexInSortedUniqueArr][i]++;
				}else{
					countArr[indexInSortedUniqueArr][i] = -1;
				}
				
				
				//change all the columns of that char ch
				if(charInterSectionArr[i][indexInSortedUniqueArr] != ch && countArr[i][indexInSortedUniqueArr] != -1){
					charInterSectionArr[i][indexInSortedUniqueArr] = ch;
					countArr[i][indexInSortedUniqueArr]++;
				}else{
					countArr[i][indexInSortedUniqueArr] = -1;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < length; i++){
			for(int j = 0; j < length; j++){
				if(countArr[i][j] > max){
					max = countArr[i][j];
				}
			}
		}
		if(max != -1){
			return max;
		}
		
		return 0;
 	}

	//will return the ordered unique chars
	private static List<Character> getCountOfUniqueChars(char[] inputArr) {
		Set<Character> uniqueChars = new TreeSet<Character>();
		for(char ch : inputArr){
			uniqueChars.add(ch);
		}
		return new ArrayList<>(uniqueChars);
	}
	
	

}
