package com.practise.dp;

/**
 * 
 * http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 * @author hruday.g
 *
 */
public class MaxSizeOfSubMatrix {
	public static void main(String[] args) {
		int inputArray[][] =  {
				{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
                };
		
		int ans = findLargestSubMatrix(inputArray);
		System.out.println(ans);
	}

	private static int findLargestSubMatrix(int[][] inputArray) {
		int noOfRows = inputArray.length;
		int noOfColumns = inputArray[0].length;
		int ans = Integer.MIN_VALUE;
		int[][] dpMatrix = new int[noOfRows][noOfColumns];
		
		for(int i = 0; i < noOfRows; i++){
			for(int j = 0; j < noOfColumns; j++){
				if(i == 0 || j == 0){
					dpMatrix[i][j] = inputArray[i][j]; 
				}else{
					if(inputArray[i][j] == 1){
						dpMatrix[i][j] = Math.min(dpMatrix[i - 1][j - 1], Math.min(dpMatrix[i][j - 1], dpMatrix[i - 1][j])) + 1;
						ans = Math.max(ans, dpMatrix[i][j]);
					}
				}
			}
		}
		
		return ans;
	}
}
