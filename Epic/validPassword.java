/*
 * In 1-9 keypad one key is not working. If someone enters a password 
 * then not working key will not be entered. You have given expected 
 * password and entered password. Check that entered password is valid 
 * or not. Ex: entered 164, expected 18684 (you need to take care as 
 * when u enter 18684 and 164 only both will be taken as 164 input)
 */

public class validPassword {
	public static void main(String[] args) {
		doTests();
	}
	
	public static boolean checkValid(String actual, String expected){
		char faultKey = '8';
		int i = 0, j = 0;
		for(;i<actual.length() && j < expected.length();j++){
			if(actual.charAt(i)!=expected.charAt(j)){
				if (faultKey != expected.charAt(j)) {
					return false;
				}
				continue;
			}
			i++;
		}
		while(j < expected.length() && expected.charAt(j) == faultKey) {
			j++;
		}
		return (i == actual.length() && j == expected.length()) ? true:false;
	}
	
	public static void doTests() {
		if (checkValid("164", "186848")) {
			System.out.println("Cool!");
		} else {
			System.out.println("Failed!");
		}
	}
}
