package com.algo.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * https://www.hackerrank.com/challenges/the-time-in-words/problem
 * 
 * @author hruday.g
 *
 */
public class TimeInWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt();
		int minutes = sc.nextInt();
		Map<Integer, String> countMap = prepareCountMap();
		Map<Integer, String> hourMap = prepareHourMap();
		Map<Integer, String> minutesMap = prepareMinutesMap();
		String timeInWords = changeTimeToWords(hour, minutes, countMap, hourMap, minutesMap);
		System.out.println(timeInWords);
		sc.close();
	}

	private static String changeTimeToWords(int hour, int minutes, Map<Integer, String> countMap,
			Map<Integer, String> hourMap, Map<Integer, String> minutesMap) {
		StringJoiner sj = new StringJoiner(" ");
		String hourStr = hourMap.get(hour);
		String minutesStr = "";
		if (minutes == 0) {
			minutesStr = minutesMap.get(minutes);
			sj.add(hourStr).add(minutesStr);
			return sj.toString();
		}else if(minutes == 45){
			hourStr = hourMap.get(hour + 1);
			sj.add(minutesMap.get(minutes)).add(hourStr);
		}
		else if(minutesMap.get(minutes) != null){
			sj.add(minutesMap.get(minutes)).add(hourStr);
		}else{
			if(minutes > 0 && minutes < 20){
				String minStr = countMap.get(minutes);
				sj.add(minStr).add("minutes").add("past").add(hourStr);
			}else if(minutes > 20 && minutes < 30){
				int minutesRoundedToTen = minutes - (minutes % 10);
				String firstMinStr = countMap.get(minutesRoundedToTen);
				int minutesRemaining = minutes % 10;
				String secondMinStr = countMap.get(minutesRemaining);
				sj.add(firstMinStr).add(secondMinStr).add("minutes").add("past").add(hourStr);
			}else if(minutes > 30 && minutes <= 59){
				int remainingMinutes = 60 - minutes;
				hourStr = hourMap.get(hour + 1);
				if(remainingMinutes > 0 && remainingMinutes <= 20){
					String minStr = countMap.get(remainingMinutes);
					sj.add(minStr).add("minutes").add("to").add(hourStr);
				}else{
					int minutesRoundedToTen = remainingMinutes - (remainingMinutes % 10);
					String firstMinStr = countMap.get(minutesRoundedToTen);
					int minutesRemaining = minutes % 10;
					String secondMinStr = countMap.get(minutesRemaining);
					sj.add(firstMinStr).add(secondMinStr).add("minutes").add("to").add(hourStr);
				}
				
			}
		}

		return sj.toString();
	}

	private static Map<Integer, String> prepareCountMap() {
		Map<Integer, String> countMap = new HashMap<>();
		countMap.put(1, "one");
		countMap.put(2, "two");
		countMap.put(3, "three");
		countMap.put(4, "four");
		countMap.put(5, "five");
		countMap.put(6, "six");
		countMap.put(7, "seven");
		countMap.put(8, "eight");
		countMap.put(9, "nine");
		countMap.put(10, "ten");

		countMap.put(11, "eleven");
		countMap.put(12, "twelve");
		countMap.put(13, "thirteen");
		countMap.put(14, "fourteen");
		countMap.put(15, "fifteen");
		countMap.put(16, "sixteen");
		countMap.put(17, "seventeen");
		countMap.put(18, "eighteen");
		countMap.put(19, "nineteen");
		countMap.put(20, "twenty");

		return countMap;

	}

	private static Map<Integer, String> prepareMinutesMap() {
		Map<Integer, String> minutesMap = new HashMap<>();
		minutesMap.put(0, "o' clock");
		minutesMap.put(15, "quarter past");
		minutesMap.put(30, "half past");
		minutesMap.put(45, "quarter to");

		return minutesMap;
	}

	private static Map<Integer, String> prepareHourMap() {
		Map<Integer, String> hourMap = new HashMap<>();
		hourMap.put(1, "one");
		hourMap.put(2, "two");
		hourMap.put(3, "three");
		hourMap.put(4, "four");
		hourMap.put(5, "five");
		hourMap.put(6, "six");
		hourMap.put(7, "seven");
		hourMap.put(8, "eight");
		hourMap.put(9, "nine");
		hourMap.put(10, "ten");
		hourMap.put(11, "eleven");
		hourMap.put(12, "twelve");

		return hourMap;
	}

}
