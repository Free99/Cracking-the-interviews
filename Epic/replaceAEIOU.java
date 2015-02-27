/*
 * Replace a,e,i,o,u with A,E,I,O,U.
 * At most four eligible letters from the rear of the string are replaced.
 * The first three eligible letters in the string are always exempted 
 * from replacement.
 */

public class replaceAEIOU {
	public static void main(String[] args) {
		doTests();
	}
	
	public static String replace(String str) {
		char[] ch = str.toCharArray(); 
		int count = 1;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == 'a' 
			 || ch[i] == 'e'
			 || ch[i] == 'i'
			 ||	ch[i] == 'o'
			 || ch[i] == 'u') {
				if (count > 3) {
					ch[i] = (char)(ch[i] - 'a' + 'A');
				} else {
					count++;
				}
			}
		}
		return String.valueOf(ch);
	}
	
	public static void doTests() {
		String test = "abebobaeioup";
		System.out.println(replace(test));
	}
}
