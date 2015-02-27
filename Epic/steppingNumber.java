import java.util.List;
import java.util.ArrayList;

/*
 * A number is called as a stepping number if the adjacent 
 * digits are having a difference of 1. For eg. 8,343,545 are 
 * stepping numbers. While 890, 098 are not. The difference 
 * between a ‘9’ and ‘0’ should not be considered as1. 
 * Given start number(s) and an end number (e) your function 
 * should list out all the stepping numbers in the range including 
 * both the numbers s & e.
 */

public class steppingNumber {
	public static void main(String[] args) {
		doTests();
	}
	
	public static void dfs(int s, int e, int length, int num, List<String> res) {
		if (length == 0) {
			return;
		}
		if (length - 1 == 0 && num > 9) {
			if (s <= num && num <= e) {
				res.add(String.valueOf(num));
				return;
			}
		}
		int lastDigit = num % 10;
		if (lastDigit == 0) {
			dfs(s, e, length - 1, num * 10 + 1, res);
		} else if (lastDigit == 9) {
			dfs(s, e, length - 1, num * 10 + 8, res);
		} else {
			dfs(s, e, length - 1, num * 10 + lastDigit - 1, res);
			dfs(s, e, length - 1, num * 10 + lastDigit + 1, res);
		}
	}
	
	public static void doTests() {
		List<String> res = new ArrayList<String>();
		String s = "1";
		String e = "10000";
		for (int i = s.length(); i <= e.length(); i++) {
			for (int j = 1; j < 10; j++) {
				dfs(Integer.parseInt(s), Integer.parseInt(e), i, j, res);
			}
		}
		System.out.println(res);
	}
}
