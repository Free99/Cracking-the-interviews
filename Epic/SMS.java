/*
 * You are given a telephone keymap
 * 0-0, 1-1, 2-ABC2, 3-DEF3, 4-GHI4, 5-JKL5, 
 * 6-MNO6,7-PQRS7, 8-TUV8, 9-WXYZ9, *-<space>, #-char separator
 * if you type "2", you will get 'A', that is "2"-'A', 
 * "22"-'B' ,"222"-'C', "2222"-'D'
 * However, the digits can repeated many times
 * "22222"-you get 'A' again -google 1point3acres
 * You can use "#" to separate characters, for example
 * "2#22", you get "AB". However, you may also have 
 * consecutive different digits without separator:"23"-'AD'
 * If you type "*", it means space. You a given a 
 * sequence of digits, translate it into a text message
 */

public class SMS {
	private static String[] map = {
		"0", "1", "ABC2","DEF3","GHI4",
		"JKL5","MON6","PQRS7","TUV8","WXYZ9"
	};
	public static void main(String[] args) {
		doTests();
	}
	
	public static String msg(String code) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < code.length(); i++) {
			if (code.charAt(i) == '*') {
				sb.append(" ");
			} else if (code.charAt(i) == '#') {
				continue;
			} else if (code.charAt(i) >= '0' && code.charAt(i) <= '9'){
				String select = map[code.charAt(i) - '0'];
				int count = 0;
				while (i + 1 < code.length() 
					&& code.charAt(i) == code.charAt(i+1)) {
					count++;
					i++;
				}
				sb.append(select.charAt(count % select.length()));
			} else {
				throw new IllegalArgumentException("Input should be"
												 + "1~9 or * or #.");
			}
		}
		return sb.toString();
	}
	
	public static void doTests() {
		System.out.println(msg("222"));   // C
		System.out.println(msg("22222")); // A
		System.out.println(msg("23"));    // AD
		System.out.println(msg("2#22"));  // AB
		System.out.println(msg("22*22")); // B B
		System.out.println(msg("2b"));	  // Failed	
	}
}
