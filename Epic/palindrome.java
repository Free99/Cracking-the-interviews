import java.util.List;
import java.util.ArrayList;

/*
 * Print all palindromes of size greater than or equal to 3 of a given string. 
 * (How to do it with DP)?
 * 
 * https://oj.leetcode.com/problems/palindrome-partitioning/
 */

public class palindrome {
	public static void main(String[] args) {
		doTests();
	}
	
	public static List<String> findPalin(String s) {
		List<String> res = new ArrayList<String>();
		if (s.length() < 3) {
			return res;
		}
		for (int start = 0; start < s.length(); start++) {
			int end = s.length() - 1;
			while (end - start >= 2) {
				if (s.charAt(start) == s.charAt(end)) {
					int i = start;
					int j = end;
					while (j > i && s.charAt(i) == s.charAt(j)) {
						i++;
						j--;
					}
					if (j <= i) {
						res.add(s.substring(start, end + 1));
					}
				}
				end--;
			}
		}
		return res;
	}
	
	public static void doTests() {
		String s = "abacolocxhooooh";
		System.out.println(findPalin(s));
	}
}
