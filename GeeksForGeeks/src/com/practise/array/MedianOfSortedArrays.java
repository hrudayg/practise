package com.practise.array;

/*
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 * 
 */
public class MedianOfSortedArrays {
	public static void main(String[] args) {
		int ar1[] = { 1, 12, 15, 26, 38 };
		int ar2[] = { 2, 13, 17, 30, 45 };
		findMedianOfSortedArrays(ar1, ar2);
	}

	private static void findMedianOfSortedArrays(int[] ar1, int[] ar2) {
		int ans = findMedianOfSortedArrays(ar1, ar2, 0, ar1.length - 1, 0, ar2.length - 1);
		System.out.println("final ans : " + ans);
	}

	private static int findMedianOfSortedArrays(int[] array1, int[] array2, int startIndex1, int endIndex1,
			int startIndex2, int endIndex2) {

		int length1 = (endIndex1 - startIndex1) + 1;
		int length2 = (endIndex2 - startIndex2) + 1;
		System.out.println("are lengths equal :"+(length1 == length2));
		int first = 0;
		int second = 0;
		int median1 = 0;
		int median2 = 0;
		int medianIndex1 = 0;
		int medianIndex2 = 0;
		if (length1 <= 0)
	        return -1;
	    if (length1 == 1)
	        return (array1[startIndex1] + array2[startIndex2])/2;
		if (length1 <= 2 && length2 <= 2) {
			if (array1[endIndex1] <= array2[startIndex2]) {
				return (array1[endIndex1] + array2[startIndex2]) / 2;
			}
			first = Math.max(array1[startIndex1], array2[startIndex2]);
			second = Math.min(array1[endIndex1], array2[endIndex2]);
			return (first + second) / 2;
		}

		if (length1 % 2 == 0) {
			second = startIndex1 + ((length1) / 2);
			first = second - 1;
			medianIndex1 = (first + second) / 2;
			median1 = array1[medianIndex1];
		} else {
			medianIndex1 = startIndex1 + length1 / 2;
			median1 = array1[medianIndex1];
		}

		if (length2 % 2 == 0) {
			second = startIndex2 + ((length2) / 2);
			first = second - 1;
			medianIndex2 = (first + second) / 2;
			median2 = array2[medianIndex2];
		} else {
			medianIndex2 = startIndex2 + length2 / 2;
			median2 = array2[medianIndex2];
		}

		System.out.println(median1);
		System.out.println(median2);

		if (median1 == median2) {
			return median1;
		}

		if (median2 > median1) {
			return findMedianOfSortedArrays(array1, array2, medianIndex1, endIndex1, startIndex2, medianIndex2);
		}
		return findMedianOfSortedArrays(array1, array2, startIndex1, medianIndex1, medianIndex2, endIndex2);

	}
}
