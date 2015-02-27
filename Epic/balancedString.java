import java.util.LinkedList;

/*
 * Given a string that has{},[],() and characters.Check if the string is 
 * balanced. E.g. {a[(b)]} is balanced. {a[(b])} is unbalanced.
 */

public class balancedString {
	public static void main(String[] args) {
		doTests();
	}
	
	public static boolean isBalanced(String s) {
		LinkedList<Character> stack = new LinkedList<Character>();
		if (s == null || s.length() == 0) {
			return true;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch(c) {
				case '(':
				case '[':
				case '{':
					stack.push(c);
					break;
				case ')':
					if (stack.isEmpty() || stack.pop() != '(') {
						return false;
					}
					break;
				case ']':
					if (stack.isEmpty() || stack.pop() != '[') {
						return false;
					}
					break;
				case '}':
					if (stack.isEmpty() || stack.pop() != '{') {
						return false;
					}
					break;
				default:
					break;
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void doTests() {
		String s = "{a[(b])}";
		if (isBalanced(s)) { 
			System.out.println("Balanced!");
		} else {
			System.out.println("Unbalanced!");
		}
	}
}
