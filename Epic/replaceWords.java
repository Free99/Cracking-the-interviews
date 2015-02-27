/*
 * Given a string. Replace the words whose length>=4 and is even, 
 * with a space between the two equal halves of the word. Consider 
 * only alphabets for finding the evenness of the word 
 * I/P "A person can't walk in this street" 
 * O/P "A per son ca n't wa lk in th is str eet"
 */

public class replaceWords {
	public static void main(String[] args) {
		doTests();
	}
	
	public static String replace(String str) {
		StringBuilder res = new StringBuilder();
		int count = 1;
		int i = 0;
		while (i < str.length()) {
			int j = i;
			while (j++ < str.length() - 1) {
				if(str.charAt(j) != ' ') {
					if ((str.charAt(j) >= 'A' && str.charAt(j) <= 'Z') 
					  || str.charAt(j) >= 'a' && str.charAt(j) <= 'z') {
						count++;
					}
					continue;
				}
				j++;
				break;
			}
			if (count >= 4 && count % 2 == 0) {
				res.append(str.subSequence(i, i + count / 2));
				res.append(" ");
				res.append(str.subSequence(i + count / 2, j));
			} else {
				res.append(str.substring(i, j));
			}
			count = 1;
			i = j;
			
		}
		return res.toString();
	}
	
	public static void doTests() {
		String test = "A person can't walk in this street";
		System.out.println(replace(test));
	}
}
