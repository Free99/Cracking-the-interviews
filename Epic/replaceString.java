/*
 * From a given string, replace all instances of 'a' with 
 * 'one' and 'A' with 'ONE'.
 * Example Input: " A boy is playing in a garden"
 * Example Output: " ONE boy is playing in one garden"
 * -- Not that 'A' and 'a' are to be replaced only when they
 * are single characters, not as part of another word.
 */

public class replaceString {
	public static void main(String[] args) {
		doTests();
	}
	
	public static String replace(String str) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == 'A' && str.charAt(i + 1) < 'A') {
				res.append("ONE");
			} else if (str.charAt(i) == 'a' && str.charAt(i + 1) < 'A') {
				res.append("one");
			} else {
				res.append(str.charAt(i));
			}
		}
		res.append(str.charAt(str.length() - 1));
		return res.toString();
	}
	
	public static void doTests() {
		String test = " A boy is playing in a garden";
		System.out.println(replace(test));
	}
}
