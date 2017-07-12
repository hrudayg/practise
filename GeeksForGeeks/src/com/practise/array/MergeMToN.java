package com.practise.array;

import java.util.Arrays;

public class MergeMToN {
	
	public static void main(String[] args) {
		int[] mPLusn = {2, -1, 7, -1, -1, 10, -1};
		moveNElementsToEnd(mPLusn, 3);
		System.out.println(Arrays.toString(mPLusn));
	}

	private static void moveNElementsToEnd(int[] mPlusn, int n) {
		int slotVacant = mPlusn.length - 1;
		int end = mPlusn.length - 1;
		
		while(n > 0){
			while(mPlusn[end] == -1){
				end--;
			}
			if(slotVacant != end){
				int temp = mPlusn[end];
				mPlusn[end] = mPlusn[slotVacant];
				mPlusn[slotVacant] = temp;
			}
			
			slotVacant--;
			n--;
		}
	}

}
