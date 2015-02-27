/*
 * The decimal and octal values of some numbers are both palindromes sometimes.
 *  Find such numbers within a given range.
 */

public class octalAndDecimalPalindrome {
	public static void main(String[] args) {
		doTests();
	}
	
	public static String decimalToOctal(int n) {
		StringBuilder sb = new StringBuilder();
		int remainder = 0;
		while (n != 0) {
			remainder = n % 8;
			n /= 8;
			sb.append(remainder);
		}
		return sb.toString();
	}
	
	public static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void checkPalindrome(int start, int end) {
		for (int i = start; i <= end; i++) {
			String dec = decimalToOctal(i);
			if (isPalindrome(String.valueOf(i)) && isPalindrome(dec)) {
				System.out.println(i);
			}
		}
	}
	
	public static void doTests() {
		int start = 0;
		int end = 1000;
		checkPalindrome(start, end);
	}
}
