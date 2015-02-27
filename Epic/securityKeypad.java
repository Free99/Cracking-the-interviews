/*
 * There is a security keypad at the entrance of a building. It has 9 
 * numbers 1 - 9 in a 3x3 matrix format
 * 1 2 3 
 * 4 5 6 
 * 7 8 9 
 * The security has decided to allow one digit error for a person but 
 * that digit should be horizontal or vertical. Example: for 5 the user 
 * is allowed to enter 2, 4, 6, 8 or for 4 the user is allowed to 
 * enter 1, 5, 7. IF the security codeto enter is 1478 and if the user 
 * enters 1178 he should be allowed. Write a function to take security 
 * code from the user and print out if he should be allowed or not.
 */

public class securityKeypad {
	public static void main(String[] args) {
		doTests();
	}
	
	public static boolean checkCode(char[][] matrix, char[] actual, char[] expected) {
		boolean errorFound = false;
		if (actual.length != expected.length) {
			return false;
		}
		for (int i = 0; i < actual.length; i++) {
			if (actual[i] == expected[i]) {
				continue;
			} else if (!errorFound) {
				errorFound = true;
				if ((expected[i] == '1' && (actual[i] == '2' || actual[i] == '4'))
				 || (expected[i] == '2' && (actual[i] == '1' || actual[i] == '3' || actual[i] == '5'))
				 || (expected[i] == '3' && (actual[i] == '2' || actual[i] == '6'))
				 || (expected[i] == '4' && (actual[i] == '1' || actual[i] == '5' || actual[i] == '7'))
				 || (expected[i] == '5' && (actual[i] == '4' || actual[i] == '2' || actual[i] == '6' || actual[i] == '8'))
				 || (expected[i] == '6' && (actual[i] == '3' || actual[i] == '5' || actual[i] == '9'))
				 || (expected[i] == '7' && (actual[i] == '4' || actual[i] == '8'))
				 || (expected[i] == '8' && (actual[i] == '7' || actual[i] == '5' || actual[i] == '9'))
				 || (expected[i] == '9' && (actual[i] == '8' || actual[i] == '6'))) {
					continue;
				} else {
					break;
				}
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void doTests() {
		char[][] matrix = { 
			{ '1', '2', '3' },
			{ '4', '5', '6' }, 
			{ '7', '8', '9' } 
		};
		char[] expected = "1478".toCharArray();
		char[] actual = "1178".toCharArray();
		if (checkCode(matrix, actual, expected)) {
			System.out.println("Allowed.");
		} else {
			System.out.println("Refused.");
		}
	}
}
