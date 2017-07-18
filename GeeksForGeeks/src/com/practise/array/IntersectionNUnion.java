package com.practise.array;

public class IntersectionNUnion {

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 4, 6, 7};
		int[] arr2 = { 2, 3, 5, 6 };

		findIntersection(arr1, arr2);
		findUnion(arr1, arr2);
	}

	private static void findUnion(int[] arr1, int[] arr2) {
		System.out.println("printing union");
		int firstIndex = 0;
		int secondIndex = 0;

		int minLength = arr1.length > arr2.length ? arr2.length : arr1.length;
		
		while (firstIndex < arr1.length && secondIndex < arr2.length) {
			if (arr1[firstIndex] < arr2[secondIndex]) {
				System.out.print(arr1[firstIndex]+" ");
				firstIndex++;
			}else if(arr1[firstIndex] > arr2[secondIndex]){
				System.out.print(arr2[secondIndex]+" ");
				secondIndex++;
			}else{
				System.out.print(arr1[firstIndex]+" ");
				firstIndex++;
				secondIndex++;
			}
			
		}
		while(firstIndex < arr1.length){
			System.out.print(arr1[firstIndex++]+" ");
		}
		
		while(secondIndex < arr2.length){
			System.out.print(arr2[secondIndex++]+" ");
		}
		System.out.println();
	}

	private static void findIntersection(int[] arr1, int[] arr2) {
		System.out.println("printing intersection");
		int firstIndex = 0;
		int secondIndex = 0;

		int minLength = arr1.length > arr2.length ? arr2.length : arr1.length;
		
		while (firstIndex < minLength && secondIndex < minLength) {
			if (arr1[firstIndex] < arr2[secondIndex]) {
				firstIndex++;
			}else if(arr1[firstIndex] > arr2[secondIndex]){
				secondIndex++;
			}else{
				System.out.print(arr1[firstIndex]+" ");
				firstIndex++;
				secondIndex++;
			}
		}
		System.out.println();
	}

}
