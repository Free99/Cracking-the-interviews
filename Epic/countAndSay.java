import java.util.List;
import java.util.ArrayList;

/*
 * First,let user input a number, say 1. Then, the function will 
 * generate the next 10 numbers which satisfy this condition: 
 * 1,11,21,1211,111221,312211... 
 * explanation: first number 1, second number is one 1, so 11. 
 * Third number is two1(previous number), so 21. next number one 
 * 2 one 1, so 1211 and so on...
 */

public class countAndSay {
	public static void main(String[] args) {
		doTests("1");
	}
	
	public static List<String> helper(String num, List<String> res, int pos) {
		if (pos == 0) {
			return res;
		}
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length() - 1; i++) {
			if (num.charAt(i) == num.charAt(i + 1)) {
				count++;
			} else { 
				sb.append(count);
				sb.append(num.charAt(i));
				count = 1;
			}
		}
		sb.append(count);
		sb.append(num.charAt(num.length() - 1));
		res.add(sb.toString());
		return helper(sb.toString(), res, pos - 1);
	}
	
	public static List<String> iteration(String num) {
		List<String> res = new ArrayList<String>();
		res.add(num);
		int N = 9;
		String cur = new String();
		while (N-- >= 1) {
			int count = 1;
			for (int i = 0; i < num.length() - 1; i++) {
				if (num.charAt(i) == num.charAt(i + 1)) {
					count++;
				} else {
					cur +=  String.valueOf(count) + String.valueOf(num.charAt(i));
					count = 1;
				}
			}
			cur += String.valueOf(count) + String.valueOf(num.charAt(num.length() - 1));
			res.add(cur);
			num = cur;
			cur = "";
		}
		return res;
	}
	
	public static void doTests(String num) {
		List<String> res = new ArrayList<String>();
		res.add(num);
		helper(num, res, 9);
		// recursive
		System.out.println(res);
		// iteration
		System.out.println(iteration(num));
	}
}
