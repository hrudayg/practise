package com.practise.arrays;

import java.util.ArrayList;

public class AddOneToNumber {

	public static void main(String[] args) {
		ArrayList<Integer> inputList = new ArrayList<>();
		inputList.add(1);
		inputList.add(2);
		inputList.add(3);
		plusOne(inputList);
	}

	private static ArrayList<Integer> plusOne(ArrayList<Integer> inputList) {
		int index = inputList.size() - 1;
		StringBuffer sb = new StringBuffer();
		int number = inputList.get(index);
		number = number + 1;
		int carry = number / 10;
		int actualNumber = number % 10;
		sb.append(actualNumber);
		index--;
		while (index >= 0 && carry != 0) {
			number = inputList.get(index);
			number = number + carry;
			carry = number / 10;
			actualNumber = number % 10;
			index--;
			sb.append(actualNumber);
		}
		
		String result = sb.reverse().toString();
		if (index >= 0) {
			for (int i = index + 1; i < index + 1 + result.length(); i++) {
				inputList.set(i, Integer.parseInt(""+result.charAt(i - (index + 1))));
			}
		}else{
			for (int i = 0; i < sb.length(); i++) {
				inputList.set(i, Integer.parseInt(""+result.charAt(i)));
			}
		}
		
		if(carry > 0){
			inputList.add(0, carry);
		}
		
		while(inputList.get(0) == 0){
			inputList.remove(0);
		}
		
		System.out.println(inputList);
		return inputList;
	}

}
