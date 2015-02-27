/*
 * Print continuous alphabets from a sequence of arbitrary alphabets 
 * For example: 
 * Input: abcdefljdflsjflmnopflsjflasjftuvwxyz 
 * Output: abcdef; lmnop; tuvwxyz
 * Input: AbcDefljdflsjflmnopflsjflasjftuvWxYz 
 * Output: abcdef; lmnop; tuvwxyz
 */

public class continuousAlphabets {
	public static void main(String[] args) {
		doTests();
	}
	
	public static void continuousAlpha(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length() - 1; i++) {
			
			sb = new StringBuilder();
			while (i < s.length() - 1 && ((s.charAt(i) + 1 == s.charAt(i + 1))
				|| (s.charAt(i) - 'a' + 'A' + 1 == s.charAt(i + 1))
				|| (s.charAt(i) - 'A' + 'a' + 1 == s.charAt(i + 1)))) {
				
				char c = s.charAt(i);
				if (c >= 'A' && c <= 'Z') {
					c = (char)(c - 'A' + 'a');
				}
				sb.append(c);
				i++;
			}
			if (((s.charAt(i - 1) + 1 == s.charAt(i))
					|| (s.charAt(i - 1) - 'a' + 'A' + 1 == s.charAt(i))
					|| (s.charAt(i - 1) - 'A' + 'a' + 1 == s.charAt(i)))) {
				char c = s.charAt(i);
				if (c >= 'A' && c <= 'Z') {
					c = (char)(c - 'A' + 'a');
				}
				sb.append(c);
				System.out.print(sb.toString() + "; ");
			}
		}
	}
	
	public static void doTests() {
		String str1 = "abcdefljdflsjflmnopflsjflasjftuvwxyz";
		String str2 = "AbcDefljdflsjflmnopflsjflasjftuvWxYz";
		continuousAlpha(str2);
	}
}
