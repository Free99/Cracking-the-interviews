/*
 * Print all valid phone numbers of length n subject to following constraints: 
 * 1.If a number contains a 4, it should start with 4 
 * 2.No two consecutive digits can be same 
 * 3.Three digits (e.g. 7,2,9) will be entirely disallowed, take as input
 */

public class telephoneNumber {
	private static String digits = "0134568";
	private static int numLength;
	
	public static void main(String[] args) {
		printPhoneNum(4);
	}
	
	public static void printPhoneNum(int len) {
		numLength = len;
		printPhoneNum("");
	}
	
	public static void printPhoneNum(String prefix) {
		if (prefix.length() == numLength) {
			System.out.println(prefix);
			return;
		}
		for (int i = 0; i < digits.length(); i++) {
			if (prefix.length() > 0) {
				// Skip two consecutive digits.
				if (prefix.charAt(prefix.length() - 1) == digits.charAt(i)) {
					continue;
				}
				// Skip if '4' appears but our phone num is not starting with '4'.
				if (prefix.length() > 0 && digits.charAt(i) == '4' 
				 && prefix.charAt(0) != '4') {
					continue;
				}
			}
			printPhoneNum(prefix + digits.charAt(i));
		}
	}
}
