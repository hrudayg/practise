package com.practise.dp;

/**
 * 
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * 
 * @author hruday.g
 *
 */
public class EditDistance {

	public static int insetionCost = 1;
	public static int removalCost = 1;
	public static int replaceCost = 1;

	public static void main(String[] args) {
		String firstString = "abcdef";
		String secondString = "azced";

		int totalCost = changeFirstStringToSecondString(firstString, secondString, firstString.length(),
				secondString.length());
		System.out.println(totalCost);
		
		int totalCostDp = changeFirstStringToSecondStringDP(firstString, secondString, firstString.length(), secondString.length());
		System.out.println(totalCostDp);
	}

	
	
	private static int changeFirstStringToSecondStringDP(String firstString, String secondString, int firstStringLength,
			int secondStringLength) {
		int[][] dpArray = new int[firstStringLength + 1][secondStringLength + 1];
		
		for(int firstStringIndex = 0; firstStringIndex <= firstStringLength; firstStringIndex++){
			for(int secondStringIndex = 0; secondStringIndex <= secondStringLength; secondStringIndex++){
				
				if(firstStringIndex == 0){
					dpArray[firstStringIndex][secondStringIndex] = secondStringIndex * EditDistance.insetionCost;
				}
				
				else if(secondStringIndex == 0){
					dpArray[firstStringIndex][secondStringIndex] = firstStringIndex * EditDistance.removalCost;
				}
				
				else if(firstString.charAt(firstStringIndex - 1) == secondString.charAt(secondStringIndex - 1)){
					dpArray[firstStringIndex][secondStringIndex] = dpArray[firstStringIndex - 1][secondStringIndex - 1]; 
				}
				
				else{
					int insertionCost = EditDistance.insetionCost + dpArray[firstStringIndex][secondStringIndex - 1];
					int removalCost = EditDistance.removalCost + dpArray[firstStringIndex - 1][secondStringIndex];
					int replaceCost = EditDistance.replaceCost + dpArray[firstStringIndex - 1][secondStringIndex - 1];
					int minCost = Math.min(insertionCost, Math.min(removalCost, replaceCost));
					dpArray[firstStringIndex][secondStringIndex] = minCost;
				}
				
			}
		}
		return dpArray[firstStringLength][secondStringLength];
	}



	private static int changeFirstStringToSecondString(String firstString, String secondString, int firstStringIndex,
			int secondStringIndex) {

		if (firstStringIndex <= 0) {
			return secondStringIndex * insetionCost;
		}

		if (secondStringIndex <= 0) {
			return firstStringIndex * removalCost;
		}

		int cost = 0;

		if (firstString.charAt(firstStringIndex - 1) == secondString.charAt(secondStringIndex - 1)) {
			cost = changeFirstStringToSecondString(firstString, secondString, firstStringIndex - 1,
					secondStringIndex - 1);
		} else {
			int insertionCost = EditDistance.insetionCost + changeFirstStringToSecondString(firstString, secondString,
					firstStringIndex, secondStringIndex - 1);
			int removalCost = EditDistance.removalCost + changeFirstStringToSecondString(firstString, secondString,
					firstStringIndex - 1, secondStringIndex);
			int replaceCost = EditDistance.replaceCost + changeFirstStringToSecondString(firstString, secondString,
					firstStringIndex - 1, secondStringIndex - 1);

			cost = cost + Math.min(Math.min(insertionCost, removalCost), replaceCost);
		}

		return cost;
	}

}
