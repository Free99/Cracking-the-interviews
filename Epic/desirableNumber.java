import java.util.List;
import java.util.ArrayList;

/*
 * A number is called 'desirable' if all the digits are strictly 
 * ascending eg: 159 as 1<5<9. You know that your rival has a strictly 
 * numeric password that is 'desirable'. Your close ally has given 
 * you the number of digits (N) in your rival's password.takes in 'N' as 
 * input and prints out all possible 'desirable' numbers that can be 
 * formed with N digits.
 */

public class desirableNumber {
	public static void main(String[] args) {
		doTests();
	}
	
	// Iteration
	public static List<String> generate(int n) {
		List<String> res =new ArrayList<String>();
		if (n <= 0) {
			return res;
		}
		res.add("");
		for (int i = 0; i < n; i++) {
			List<String> item = new ArrayList<String>();
			for (String str : res) {
				if (str.length() == 0) {
					for (char c = '0'; c <= '9'; c++) {
						item.add(str + c);
					}
				} else {
					char last = str.charAt(str.length() - 1);
					for (char c = (char)(last + 1); c <= '9'; c++) {
						item.add(str + c);
					}
				}
			}
			res = item;
		}
		return res;
	}
	
	// Recursive
	public static List<String> generate1(int n) {
		List<String> res = new ArrayList<String>();
		if (n <= 0) {
			return res;
		}
		generate1(n, 0, res, new StringBuilder());
		return res;
	}
	
	public static void generate1(int n, int start, List<String> res, StringBuilder sb) {
		if (n <= 0) {
			res.add(sb.toString());
			return;
		}
		for (int i = start; i <= 9; i++) {
			sb.append(i);
			generate1(n - 1, i + 1, res, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	public static void doTests() {
		List<String> res1 = generate(3);
		System.out.println(res1);
		
		List<String> res2 = generate1(3);
		System.out.println(res2);
	}
}
