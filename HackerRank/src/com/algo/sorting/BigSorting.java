package com.algo.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/big-sorting
 * @author hruday.g
 *
 */
public class BigSorting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalNumbers = sc.nextInt();
		List<String> aList = new ArrayList<>();
		
		for(int i = 0; i < totalNumbers; i++){
			aList.add(sc.next());
		}

		//System.out.println(aList);
		
		aList.sort(new Comparator<String>() {

			@Override
			public int compare(String firstString, String secondString) {
				if(firstString.length() > secondString.length()){
					return 1;
				}else if(firstString.length() < secondString.length()){
					return -1;
				}else{
					return firstString.compareTo(secondString);
				}
				
			}
		});
		
		for(int i = 0; i < totalNumbers; i++){
			System.out.println(aList.get(i));
		}
		
		sc.close();
	}
}
