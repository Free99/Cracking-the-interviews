/*
 * Verify if the given password is valid/invalid
 * 1. must be 5-12 characters long 
 * 2. must contain at least one number and one lower case character 
 * 3. a sequence must not be followed by the same sequence 
 * (like 123123qs is invalid, 123qs123 is valid)
 */

public class verifyPassword {
	public static void main(String[] args) {
		doTests();
	}
	
	public static boolean isValid(String password) {
		if (password.length() < 5 || password.length() > 12) {
			return false;
		}
		boolean lowerFlag = false;
		boolean numFlag = false;
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (numFlag == false && c >= '0' && c <= '9') {
				numFlag = true;
			}
			if (lowerFlag == false && c >= 'a' && c <= 'z') {
				lowerFlag = true;
			}
			int index = password.indexOf(c, i + 1);
			if (index != -1) {
				String str1 = password.substring(i, index);
				if (2 * index - i <= password.length()) {
					String str2 = password.substring(index, 2 * index - i);
					if (str1.equals(str2)) {
						return false;
					}
				}
			}
		}
		return numFlag && lowerFlag;
	}
	
	public static void doTests() {
		String password1 = "123123qs";
		String password2 = "123qs123";
		if (isValid(password1)) {
			System.out.println("Valid!");
		} else {
			System.out.println("Invalid!");
		}
		if (isValid(password2)) {
			System.out.println("Valid!");
		} else {
			System.out.println("Invalid!");
		}
	}
}
