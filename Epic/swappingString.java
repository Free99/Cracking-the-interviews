/*
 * Given two strings, you need to transpose the first string to 
 * the second string by means of only swaps between 2 consecutive 
 * characters in the first string. This must be performed by doing a 
 * series of these swaps in order to get the second string.
 */

public class swappingString {
	public static void main(String[] args) {
		doTests();
	}
	
	public static boolean transpose(char[] s1, char[] s2) {
		
		if (s1.length != s2.length) {
			return false;
		} else {
			int i = 0;
			int count = 0;
			while (i < s1.length) {
				if (s1[i] == s2[i]) {
					i++;
					count = 0;
					continue;
				} else {
					for (int j = i; j < s1.length - 1; j++) {
						char temp = s1[j];
						s1[j] = s1[j + 1];
						s1[j + 1] = temp;
						++count;
						if (count == s1.length * (s1.length - 1)) {
							return false;
						}
					}
				}
			}
			return true;
		}
		
	}
	
	public static void doTests() {
		char[] s1 = "TEHUNOOL".toCharArray();
		char[] s2 = "ONLEHTUO".toCharArray();
		char[] s3 = "abcde".toCharArray();
		char[] s4 = "aopqr".toCharArray();
		
		if (transpose(s1, s2)) {
			System.out.println("Yah!");
		} else {
			System.out.println("Failed!");
		}
		
		if (transpose(s3, s4)) {
			System.out.println("Yah!");
		} else {
			System.out.println("Failed!");
		}
		
		
	}
}
