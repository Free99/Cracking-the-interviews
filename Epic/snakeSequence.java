/*
 * You are given a grid of numbers. A snake sequence is made up of 
 * adjacent numbers such that for each number, the number on the right 
 * or the number below it is +1 or -1 its value. For example, 
 *  1 3 2 6 8 
 * -9 7 1 -1 2 
 *  1 5 0 1 9 
 *  In this grid, (3, 2, 1, 0, 1) is a snake sequence. 
 *  Given a grid, find the longest snake sequences and their lengths 
 *  (so there can be multiple snake sequences with the maximum length).
 *  
 *  二维动归看 ⬇ 问题3
 *  http://blog.csdn.net/lsdtc1225/article/details/39949367
 */
public class snakeSequence {
	public static void main(String[] args) {
		doTests();
	}
	
	public static int findSnake(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int maxLen = 0;
		int[] dp = new int[matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++) {
			dp[i] = 1;
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j <matrix[0].length; j++) {
				if (i > 0 && Math.abs(matrix[i - 1][j] - matrix[i][j]) == 1) {
					dp[j] = dp[j] + 1;
				}
				if (j > 0 && Math.abs(matrix[i][j - 1] - matrix[i][j]) == 1) {
					dp[j] = dp[j-1] + 1; 
				}
				maxLen = Math.max(maxLen, dp[j]);
			}
		}
		return maxLen;
	}
	
	public static void doTests() {
		int[][] matrix1 = {
				{1, 3, 2, 6, 8},
			    {-9, 7, 1, -1, 2},
			    {1, 5, 0, 1, 9}	
		};
		int[][] matrix2 = {
				{1, 1, 2, 3, 1}, 
				{1, 1, 3, 4, 5},
				{1, 1, 4, 1, 6}
		};
		System.out.println(findSnake(matrix2));
	}
}
