import java.util.List;
import java.util.ArrayList;

/*
 * Something cost $10.25 and the customer pays with a $20 bill, the 
 * program will print out the most efficient "change-breakdown" which 
 * is 1 five, 4 ones, and 3quarters. Find the minimum number of coins 
 * required to make change for a given sum (given unlimited number of N 
 * different denominations coin)
 */

public class coinChange {
	public static void main(String[] args) {
		doTests();
	}
	
	public static List<Double> helper(double[] coins, double target, int pos, List<Double> way) {
		if (target == 0) {
			return way;
		} else if (target < 0) {
			way.remove(way.size() - 1);
			way.add(coins[pos + 1]);
			return helper(coins, target + coins[pos] - coins[pos+1], pos + 1, way);
		} else {
			way.add(coins[pos]);
			return helper(coins, target - coins[pos], pos, way);
		}
	}
	
	public static void doTests() {
		double[] coins = {5.0, 1.0, 0.25, 0.1, 0.05, 0.01};
		double target = 20;
		double cost = 10.25;
		List<Double> res = new ArrayList<Double>();
		helper(coins, target - cost, 0, res);
		System.out.println(res);
	}
}
