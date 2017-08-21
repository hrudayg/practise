package com.practise.array;

import java.util.Stack;

/**
 * 
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * 
 * @author hruday.g
 *
 */
public class Histogram {
	public static void main(String[] args) {
		int[] inputArr = {  6, 2, 5, 4, 5, 1, 6 };
		int ans = findLargestRectangleUnderHistogram(inputArr);
		System.out.println("Max area is :"+ans);
	}

	private static int findLargestRectangleUnderHistogram(int[] inputArr) {
		Stack<Integer> aStack = new Stack<>();
		aStack.push(0);
		
		int maxArea = Integer.MIN_VALUE;
		int index = 1;
		while(index < inputArr.length){
			int number = inputArr[index];
			int topOfStack = inputArr[aStack.peek()];
			
			if(number >= topOfStack){
				aStack.push(index);
			}else{
				int area = 0;
				while(!aStack.isEmpty() && inputArr[aStack.peek()] > number){
					int popedIndex = aStack.pop();
					//find the area with the poped index as the smallest bar
					if(!aStack.isEmpty()){
						topOfStack = aStack.peek();
						area = inputArr[popedIndex] * (index - topOfStack - 1); 
					}else{
						area = inputArr[popedIndex] * index;
					}
					maxArea = Math.max(area, maxArea);
				}
				
				aStack.push(index);
			}
			index++;
		}
		
		while(!aStack.isEmpty()){
			int popedIndex = aStack.pop();
			//find the area with the poped index as the smallest bar
			int area = 0;
			if(!aStack.isEmpty()){
				int topOfStack = aStack.peek();
				area = inputArr[popedIndex] * (index - topOfStack - 1); 
			}else{
				area = inputArr[popedIndex] * index;
			}
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}
}
