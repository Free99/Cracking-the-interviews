import java.util.List;
import java.util.ArrayList;

/*
 * http://blog.csdn.net/lsdtc1225/article/details/39949367
 * 问题17：
 * 感觉和上面的题又有点像， 给一个string， 里面不能有数字。 然后所有的大写字母和非字母符号不能动, 
 * 其他的小写字母可以随意动。 输出所有的可能。
 * e.g. input Oh my-god!
 * output Om hd-goy! Oy hm-dog! 等等。
 */

public class letterPermutation {
	public static void main(String[] args) {
		doTests();
	}
	
	public static void helper(List<String> res, StringBuilder sb, 
							  List<Character> candidate, List<Integer> position,
							  boolean[] occured, int index) {
		if (index == position.size()) {
			res.add(sb.toString());
			return;
		}
		for (int i = index; i < position.size(); i++) {
			if (!occured[i]) {
				occured[i] = true;
				for (int j = 0; j < candidate.size(); j++) {
					sb.setCharAt(position.get(i), candidate.get(j));
					char c = candidate.remove(j);
					helper(res, sb, candidate, position, occured, index + 1);
					candidate.add(j, c);
				}
				occured[i] = false;
			}
		}
	}
	
	public static void doTests() {
		List<String> res = new ArrayList<String>();
		List<Character> candidate = new ArrayList<Character>();
		List<Integer> position = new ArrayList<Integer>();
		String s = "Oh my-god!";
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isAlphabetic(c) && Character.isLowerCase(c)) {
				candidate.add(c);
				position.add(i);
			}
		}
		boolean[] occured = new boolean[candidate.size()];
		helper(res, sb, candidate, position, occured, 0);
		System.out.println(res);
	}
}
