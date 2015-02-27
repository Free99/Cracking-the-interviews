/*
 * Given aNXN matrix, starting from the upper right corner of the 
 * matrix start printingvalues in a counter-clockwise fashion. 
 * E.g.: Consider N = 4 
 * Matrix= {
 * 			a, b, c, d, 
 * 			e, f, g, h, 
 * 			i, j, k, l, 
 * 			m, n, o, p} 
 * Your function should output: dcbaeimnoplhgfjk
 */
public class spiralMatrix {
	public static void main(String[] args) {
		doTests();
	}
	
	public static String rotate(char[][] matrix) {
		StringBuilder res = new StringBuilder();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return "";
		}
		int min = Math.min(matrix.length, matrix[0].length);
		int levelNum = min / 2;
		for (int level = 0; level < levelNum; level++) {
			for (int i = matrix[0].length - level - 1; i > level; i--) {
				res.append(matrix[level][i]);
			}
			for (int i = level; i < matrix.length - level - 1; i++) {
				res.append(matrix[i][level]);
			}
			for (int i = level; i < matrix[0].length - level - 1; i++) {
				res.append(matrix[matrix.length - level - 1][i]);
			}
			for (int i = matrix.length - level - 1; i > level; i--) {
				res.append(matrix[i][matrix[0].length - level - 1]);
			}
		}
		return res.toString();
	}
	
	public static void doTests() {
		char[][] matrix = {
			{'a', 'b', 'c', 'd'},
		    {'e', 'f', 'g', 'h'}, 
		    {'i', 'j', 'k', 'l'}, 
		    {'m', 'n', 'o', 'p'}
		};
		String res = rotate(matrix);
		System.out.println(res);
	}
}
