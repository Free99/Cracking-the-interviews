/*
 * Given an NxN matrix with unique integers : Find and print positions 
 * of all numbers such that it is the biggest in its row and also the 
 * smallest in its column . e.g. : In 3 x 3 with elements 
 * 1 2 3 
 * 4 5 6 
 * 7 8 9 
 * the number is 3 and position (1,3)
 */

public class matrixPosition {
	public static void main(String[] args) {
		doTests();
	}
	
	public static String finder(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return "";
		}
		for (int i = 0; i < matrix.length; i++) {
			int rowMax = Integer.MIN_VALUE;
			int col = -1;
			int colMin = Integer.MAX_VALUE;
			int row = -1;
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] > rowMax) {
					rowMax = matrix[i][j];
					col = j;
				}
			}
			int mark = i;
			for (int k = mark; k < matrix.length; k++) {
				if (matrix[k][col] < colMin) {
					colMin = matrix[k][col];
					row = k;
				}
			}
			if (mark != 0) {
				for (int k = mark; k >= 0; k--) {
					if (matrix[k][col] < colMin) {
						colMin = matrix[k][col];
						row = i;
					}
				}
			}
			if (colMin == rowMax) {
				return "(" + (row + 1) + ", " + col + ")";
			}
		}
		return "";
	}
	
	public static void doTests() {
		int[][] matrix = {
			{1, 2, 3}, 
			{4, 5, 6},
			{7, 8, 9} 	
		};
		System.out.println(finder(matrix));
	}
}
