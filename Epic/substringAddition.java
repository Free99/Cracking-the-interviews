/*
 * Write a program to add the substring. 
 * eg :say you have a list {1 7 6 3 5 8 9 }
 * and user is entering a sum 16. Output should display(2-4) that is {7 6 3} 
 * cause 7+6+3=16.
 */
public class substringAddition {
	public static void main(String[] args) {
		doTests();
	}
	
	public static void sumSub(int[] list, int target) {
		if (list == null || list.length == 0) {
			System.out.println("Failed.");
			return;
		}
		for (int i = 0; i < list.length; i++) {
			int sum = list[i];
			int j = i;
			while (++j < list.length && sum < target) {
				sum += list[j];
			}
			if (sum == target) {
				System.out.println("(" + (i + 1) + "-" + j + ")");
			}
		}
	}
	
	public static void doTests() {
		int[] list = {1, 7, 6, 3, 5, 8, 9};
		int target = 16;
		sumSub(list, target);
	}
}
