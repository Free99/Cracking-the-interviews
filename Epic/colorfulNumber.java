import java.util.HashSet;
import java.util.Set;

/*
 * A number can be broken into different sub-sequence parts. 
 * Suppose a number 3245 can bebroken into parts 
 * like 3 2 4 5 32 24 45 324 245. And this number is a colorfulnumber, 
 * since product of every digit of a sub-sequence are different. 
 * That is,3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20 (3*2*4)= 24 (2*4*5)= 40. 
 * But 326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12. 
 * You have to write a function that tells if the given number 
 * is a colorful number or not.
 */

public class colorfulNumber {
	public static void main(String[] args) {
		doTests();
	}
	
	public static boolean isColorful(int number) {
		if (number < 10) {
			return true;
		}
		String str = String.valueOf(number);
		int length = str.length();
		Set<Integer> colorMap = new HashSet<Integer>();
		for (int i = 1; i < length; i++) {
			for (int j = 0; j + i <= length; j++) {
				String sub = str.substring(j, j+i);
				int product = getProduct(Integer.parseInt(sub));
				if (colorMap.contains(product)) {
					return false;
				} else {
					colorMap.add(product);
				}
			}
		}
		return true;
	}
	
	public static int getProduct(int digits) {
		if (digits < 10) {
			return digits;
		}
		int num = digits;
		int product = 1;
		while (num > 0) {
			product = product * (num % 10);
			num = num / 10;
		}
		return product;
	}
	
	public static void doTests() {
		if (isColorful(3245)) {
			System.out.println("Good!");
		} else {
			System.out.println("Failed.");
		}
		
		if (isColorful(326)) {
			System.out.println("Good!");
		} else {
			System.out.println("Failed.");
		}
	}
}
