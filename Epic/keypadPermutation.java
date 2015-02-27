import java.util.List;
import java.util.ArrayList;

/*
 * Phone has letters on the number keys. For example, 
 * number 2 has ABC on it, number 3 has DEF, 4 number has GHI,..., 
 * and number 9 has WXYZ. Write a program that will print out 
 * all of the possible combination of those letters depending 
 * on the input. 
 */

public class keypadPermutation {
	private static String[] map = {
		"", "", "abc", "def", "ghi", "jkl", 
		"mno", "pqrs", "tuv", "wxyz"
	};
	
	public static void main(String[] args) {
		doTests();
	}
	
	public static void helper(String digits, List<String> res, StringBuilder item, int pos) {
		if (pos == digits.length()) {
			res.add(item.toString());
			return;
		}
		String select = map[digits.charAt(pos) - '0'];
		for (int i = 0; i < select.length(); i++) {
			item.append(select.charAt(i));
			helper(digits, res, item, pos + 1);
			item.deleteCharAt(item.length() - 1);
		}
	}
	
	public static void doTests() {
		String digits = "23";
		List<String> res = new ArrayList<String>();
		helper(digits, res, new StringBuilder(), 0);
		System.out.println(res);
	}
}
