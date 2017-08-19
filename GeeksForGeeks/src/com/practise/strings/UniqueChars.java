package com.practise.strings;


/**
 * 
 * http://www.geeksforgeeks.org/determine-string-unique-characters/
 * @author hruday.g
 *
 */
public class UniqueChars {
	
	public static void main(String[] args) {
		String input = "prathyusha";
		boolean isUnique = findIfStringHasUniqueChars(input);
		System.out.println(isUnique);
	}

	
	/*
	 * This method only works for string in lower cases
	 * 
	 */
	private static boolean findIfStringHasUniqueChars(String input) {
		int checker = 0;
		
		for(int index = 0; index < input.length(); index++){
			int indexOfChar = input.charAt(index) - 'a';
			
			if((checker & (1 << indexOfChar)) > 0){
				return false;
			}
			
			checker = checker | 1 << indexOfChar;
			
			System.out.println("checker is :"+checker);
		}
		
		return true;
	}

}
