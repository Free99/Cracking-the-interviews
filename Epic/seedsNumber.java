import java.util.List;
import java.util.ArrayList;

/*
 * Find the seed of a number
 * Eg : 1716 = 143*1*4*3 =1716 so 143 is the seed of 1716. 
 * find all possible seed for a given number.
 */
public class seedsNumber {
	public static void main(String[] args) {
		doTests();
	}
	
	public static List<Integer> seedNum(int num) {
		List<Integer> seeds = new ArrayList<Integer>();
		if (num == 0 || num == 1) {
			seeds.add(num);
			return seeds;
		}
		for (int i = (int) Math.sqrt(num); i <= num / 2; i++) {
			if (num % i == 0) {
				int temp = i;
				int res = i;
				while (temp != 0) {
					res *= temp % 10;
					temp /= 10;
				}
				if (res == num) {
					seeds.add(i);
				}
			}
		}
		return seeds;
	}
	
	public static void doTests() {
		int num = 1716;
		System.out.println(seedNum(num));
	}
}
