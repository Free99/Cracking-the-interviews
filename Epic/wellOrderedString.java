/*
 * You know a password is well-ordered string. 
 * Well-ordered string means that the order of the 
 * characters is in an alphabetical increasing order.
 * Like abEm is a well-ordered number. However,
 * abmE is not a well-order number. Given an input # that 
 * tells you also how many digits are in the password, 
 * print all possible passwords.
 */

public class wellOrderedString {
	public static void main(String[] args) {
		generate(3);
	}
	
	public static void generate(int n){
		 if(n <= 0) return;
		 generate(n,0,"");
	}
	
	private static void generate(int n, int start, String prefix){
		if(n==0) {
			System.out.print(prefix + ",");
			return;
		}
		for(int i = start; i<26;i++) {
			generate(n - 1, i + 1, prefix + (char)('a' + i));
			generate(n - 1, i + 1, prefix + (char)('A' + i));
		 }
	}
}
