package com.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeightedUniformStrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<Integer, Integer> posW = new HashMap<>();
		String s = in.next();
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			int counter = 1;
			posW.put((temp - 96) * counter, 0);
			while (i + 1 < s.length() && temp == s.charAt(i + 1)) {
				i++;
				counter++;
				posW.put((temp - 96) * counter, 0);
			}
		}

		int n = in.nextInt();
		for (int a0 = 0; a0 < n; a0++) {
			int x = in.nextInt();
			if (posW.containsKey(x)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

}
