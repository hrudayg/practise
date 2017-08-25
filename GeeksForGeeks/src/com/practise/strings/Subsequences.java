package com.practise.strings;

/**
 * 
 * http://www.geeksforgeeks.org/print-possible-strings-can-made-placing-spaces-2/
 * 
 * @author hruday.g
 *
 */
public class Subsequences {
	public static void main(String[] args) {
		String input = "abcd";
		printSubsequences(input, 1, "" + input.charAt(0));
	}

	private static void printSubsequences(String input, int index, String outputStr) {
		if (index >= input.length()) {
			System.out.println(outputStr);
			return;
		}

		String firstString = outputStr +" "+input.charAt(index);
		String secondString = outputStr + input.charAt(index);
		printSubsequences(input, index + 1, firstString);
		printSubsequences(input, index + 1, secondString);
	}

}
