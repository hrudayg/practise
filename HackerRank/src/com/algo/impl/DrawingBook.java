package com.algo.impl;

import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/drawing-book/problem
 * 
 * @author hruday.g
 *
 */
public class DrawingBook {
	static int solve(int totalNoOfPages, int pageNumber) {
		int fromStart = findFromStart(totalNoOfPages, pageNumber);
		int fromEnd = fromEnd(totalNoOfPages, pageNumber);
		return Math.min(fromStart, fromEnd);
	}

	private static int fromEnd(int totalNoOfPages, int pageNumber) {
		if (totalNoOfPages % 2 == 0) {
			return (totalNoOfPages + 1 - pageNumber) / 2;
		}
		return (totalNoOfPages - pageNumber) / 2;
	}

	private static int findFromStart(int totalNoOfPages, int pageNumber) {
		return pageNumber / 2;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int p = in.nextInt();
		int result = solve(n, p);
		System.out.println(result);
		in.close();
	}
}
