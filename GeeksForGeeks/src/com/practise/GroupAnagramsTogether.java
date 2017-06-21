package com.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GroupAnagramsTogether {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		for (int i = 0; i < noOfTestCases; i++) {
			int noOfStrings = sc.nextInt();
			HashMap<String, Integer> strCountMap = new HashMap<>();
			for (int index = 0; index < noOfStrings; index++) {
				String inputString = sc.next();
				char[] stringChars = inputString.toCharArray();
				Arrays.sort(stringChars);
				String newString = new String(stringChars);
				Integer count = strCountMap.get(newString);
				if (count == null) {
					strCountMap.put(newString, 1);
				} else {
					strCountMap.put(newString, count + 1);
				}
			}

			Collection<Integer> values = strCountMap.values();
			List<Integer> countList = new ArrayList<>(values);
			Collections.sort(countList);
			for (int listIndex = 0; listIndex < countList.size(); listIndex++) {
				System.out.print(countList.get(listIndex) + " ");
			}
			System.out.println("");
		}
	}

}
