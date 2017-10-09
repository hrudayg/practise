package com.algo.recursion;

import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/password-cracker/problem
 * 
 * @author i339211
 *
 */
public class PasswordCracker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalTestCases = sc.nextInt();
		for (int testCase = 0; testCase < totalTestCases; testCase++) {
			int totalPassWords = sc.nextInt();
			//Set<String> passwordsSet = new HashSet<>();
			sc.nextLine();
			String passwordsString = sc.nextLine();
			String[] passwords = passwordsString.split(" ");
//			for (String password : passwords) {
//				passwordsSet.add(password);
//			}
			String passwordEntered = sc.nextLine();
			StringBuffer sb = new StringBuffer();
			String matchedPasswords = isPasswordMathcded(passwords, passwordEntered, sb, 0);
			if (matchedPasswords.length() > 0) {
				System.out.println(matchedPasswords);
			} else {
				System.out.println("WRONG PASSWORD");
			}
		}
		sc.close();
	}

	private static String isPasswordMathcded(String[] passwords, String passwordEntered, StringBuffer sb, int index) {
		if (passwordEntered.length() == 0) {
			return sb.toString();
		}
		boolean isFound = false;
		int i = 0;
		for (i = index; i < passwords.length; i++) {
			if (passwordEntered.startsWith(passwords[i])) {
				isFound = true;
				passwordEntered = passwordEntered.replaceFirst(passwords[i], "");
				sb.append(passwords[i]).append(" ");
			}
		}
		if (isFound) {
			if(i >= passwords.length) {
				return isPasswordMathcded(passwords, passwordEntered, sb, 0);
			}else {
				return isPasswordMathcded(passwords, passwordEntered, sb, i);
			}
			
		} else {
			return "";
		}
	}

}
