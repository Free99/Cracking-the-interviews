/*
 * A magic square of order n is an arrangement of the numbers from 1 to n^2 
 * in an n by n matrix with each number occurring exactly once so that each row, 
 * each column and each main diagonal has the same sum. Then should be an odd 
 * number. In the middle cell of the top row, fill number 1.Then go to above 
 * row and right column, and fill following number 2. If it’s out of boundary, 
 * go to the opposite row or column. If the next cell is already occupied, go 
 * to the cell below this cell and fill following number. An example 
 * of 5*5 grid is like this for the first 9 numbers:
 * 0 0 1 8 0
 * 0 5 7 0 0
 * 4 6 0 0 0
 * 0 0 0 0 3
 * 0 0 0 2 9
 */

public class magicSquare {
	public static void main(String[] args) {
		doTests();
	}
	
	public static int[][] magicSet(int n) {
		if (n < 0 || n % 2 == 0) {
			throw new IllegalArgumentException("Error.");
		}
		int[][] matrix = new int[n][n];
		int count = 1;
		int row = 0;
		int col = n / 2;
		while (count <= n * n) {
			if (row < 0) {
				row = n - 1;
			}
			if (row > n - 1) {
				row = row - n;
			}
			if (col < 0) {
				col = n - 1;
			}
			if (col > n - 1) {
				col = 0;
			}
			if (matrix[row][col] == 0) {
				matrix[row][col] = count++;
				row--;
				col++;
			} else {
				row = row + 2;
				col--;
			}
		}
		return matrix;
	}
	
	public static void doTests() {
		int[][] matrix = magicSet(5);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] < 10) {
					System.out.print(matrix[i][j] + "  ");
				} else {
					System.out.print(matrix[i][j] + " ");
				}
				
			}
			System.out.println();
		}
	}
}
