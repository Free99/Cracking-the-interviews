/*
 * N*N matrix is given with input red or black.You can move horizontally, 
 * vertically or diagonally. If 3 consecutive same color found, that color 
 * will get 1 point. So if 4 red are vertically then point is 2. Find the winner.
 */

public class ticTacToe {
	public static void main(String[] args) {
		doTests();
	}
	
	public static int checkPoints(char[][] matrix, char c) {
		int count = 0;
		// Check horizontal
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length - 2; j++) {
				if (matrix[i][j] == c 
				 && matrix[i][j + 1] == c 
				 && matrix[i][j + 2] == c) {
					count++;
				}
			}
		}
		// Check vertical
		for (int i = 0; i < matrix.length - 2; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == c 
				 && matrix[i + 1][j] == c
				 && matrix[i + 2][j] == c) {
					count++;
				}
			}
		}
		// From topLeft to downRight
		for (int i = 0; i < matrix.length - 2; i++) {
			for (int j = 0; j < matrix[0].length - 2; j++) {
				if (matrix[i][j] == c
				 && matrix[i + 1][j + 1] == c
				 && matrix[i + 2][j + 2] == c) {
					count++;
				}
			}
		}
		// From downLeft to topRight
		for (int i = matrix.length - 1; i > 1; i--) {
			for (int j = 0; j < matrix[0].length - 2; j++) {
				if (matrix[i][j] == c
				 && matrix[i - 1][j + 1] == c
				 && matrix[i - 2][j + 2] == c) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void doTests() {
		char[][] matrix = { 
			{ 'r', 'r', 'r', 'b' }, 
			{ 'b', 'r', 'b', 'r' },
			{ 'b', 'r', 'r', 'b' }, 
			{ 'b', 'r', 'b', 'b' } 
		};
		int countR = checkPoints(matrix, 'r');
		int countB = checkPoints(matrix, 'b');
		if (countR > countB) {
			System.out.println("Red wins!");
		} else {
			System.out.println("Black wins");
		}
	}
}
