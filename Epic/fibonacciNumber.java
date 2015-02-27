import java.util.List;
import java.util.ArrayList;

/*
 * There is one kind of numbers call FibbonaciNumber, which satisfy 
 * the following situation:
 * A. can be split into several numbers;
 * B. The first two number are the same, the next number is equal to 
 * the sum of previous two
 * eg. 112 (2 = 1 + 1), 12,122,436(12 + 12 = 24,12 + 24 = 36)
 * If you are given a range by the user, find all numbers that are 
 * Fibonacci numbers.
 */

public class fibonacciNumber {
	public static void main(String[] args) {
		doTests();
	}
	
	public static boolean isFibonacci(int num) {
		String str = String.valueOf(num);
		for (int i = 1; i < str.length(); i++) {
			int j = 2 * i;
			if (j < str.length()) {
				int part1 = Integer.parseInt(str.substring(0, i));
				int part2 = Integer.parseInt(str.substring(i, j));
				if (part1 != part2) {
					continue;
				}
				int index = j;
				int rest = Integer.parseInt(str.substring(j, str.length()));
				while (part1 + part2 <= rest) {
					int part3 = part1 + part2;
					String p3 = String.valueOf(part3);
					int len = p3.length();
					if (index + len > str.length()) {
						break;
					}
					if (str.substring(index, index + len).equals(p3)) {
						index = index + len;
						if (index == str.length()) {
							return true;
						}
						part1 = part2;
						part2 = part3;
						rest = Integer.parseInt(str.substring(index, str.length()));
					} else {
						break;
					}
				}
			}
		}
		return false;
	}
	
	public static void doTests() {
		int l = 1;
		int r = 12122437;
		if (isFibonacci(12122436)) {
			System.out.println("Hi");
		}
		
		List<Integer> res = new ArrayList<Integer>();
		for (int i = l; i <= r; i++) {
			if (isFibonacci(i)) {
				res.add(i);
			}
		}
		System.out.println(res);
	}
}
