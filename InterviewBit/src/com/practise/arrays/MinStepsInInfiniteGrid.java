package com.practise.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 * 
 */

public class MinStepsInInfiniteGrid {

	public static void main(String[] args) {
		List<Integer> xList = new ArrayList<>();
		List<Integer> yList = new ArrayList();

		/*
		 * sample input
		 */

		int[] xIndices = { -5, 7, -12, 4, -6, 2, -5, -12, -6, 3, 11, 10, -8, 11, -13, -8, 5, -12, 4, 4 };
		int[] yIndices = { -6, 6, -8, -13, -2, -9, -10, -10, -7, -14, 9, -8, -4, 8, 13, -11, 13, 5, 9, 11 };

		/*xList.add(0);
		xList.add(1);
		xList.add(1);

		yList.add(0);
		yList.add(1);
		yList.add(2);*/
		
		for(int i = 0; i < xIndices.length; i++){
			xList.add(xIndices[i]);
			yList.add(yIndices[i]);
		}

		int ans = coverPoints(xList, yList);

		System.out.println(ans);
	}

	private static int coverPoints(List<Integer> xList, List<Integer> yList) {
		int xFirst = xList.get(0);
		int yFirst = yList.get(0);

		int index = 1;
		int distance = 0;
		while (index < xList.size()) {
			int xSecond = xList.get(index);
			int ySecond = yList.get(index);

			int xDiff = Math.abs(xSecond - xFirst);
			int yDiff = Math.abs(ySecond - yFirst);

			if (xDiff == yDiff) {
				distance = distance + xDiff;
			} else {
				distance = distance + (Math.min(xDiff, yDiff)) + Math.abs(xDiff - yDiff);
			}

			xFirst = xSecond;
			yFirst = ySecond;
			index++;
		}

		return distance;
	}

}
