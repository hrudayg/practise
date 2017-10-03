package com.threads.cyclicbarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		int length = 3;
		int[][] matrix = createMatrix(length);
		printMatrix(matrix);
		Solver solver = new Solver(matrix, length);
		printMatrix(matrix);
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] createMatrix(int length) {
		int[][] matrix = new int[length][length];
		int counter = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				matrix[i][j] = counter++;
			}
		}

		return matrix;
	}
}
