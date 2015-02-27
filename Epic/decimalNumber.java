/*
 * Let the user enter a decimal number. The range allowed is 0.0001 to 0.9999.
 * Only four decimal places are allowed. The output should be an irreducible 
 * fraction. E.g.: If the user enters 0.35,the irreducible fraction will be 7/20.
 */

public class decimalNumber {
	public static void main(String[] args) {
		doTests();
	}
	
	public static void fraction(double input) {
		int x = (int) (input * 10000);
		int div = GCD(x, 10000);
		System.out.println(x / div + "/" + 10000 / div);
	}
	
	public static int GCD(int m, int n) {
		if (m < n) {
			int t = m;
			m = n;
			n = t;
		}
		if (m % n == 0) {
			return n;
		} else {
			return GCD(n, m % n);
		}
	}
	
	public static void doTests() {
		double input = 0.35;
		fraction(input);
	}
}
