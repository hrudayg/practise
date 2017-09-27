package com.algo.impl;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/grading/problem
 * @author hruday.g
 *
 */
public class GradingStudents {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		
		for(int testCase = 0; testCase < noOfTestCases; testCase++){
			int grade = sc.nextInt();
			int modifiedGrade = findNextGrade(grade);
			System.out.println(modifiedGrade);
		}
		
		sc.close();
	}

	private static int findNextGrade(int grade) {
		if(grade <= 35 || grade % 5 == 0){
			return grade;
		}else{
			int fiveMultiple = grade / 5;
			int nextMultiple = (fiveMultiple + 1) * 5;
			if(nextMultiple - grade < 3){
				grade = nextMultiple;
			}
		}
		return grade;
	}

}
