/*
 * Write, efficient code for extracting unique elements from a sorted 
 * list of array. e.g. (1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9)-> (1, 3, 5, 9).
 */

public class uniqueNumber {
	public static void main(String[] args) {
		doTests();
	}
	
	public static int[] removeDup(int[] a) {
		int[] res = new int[a.length];
		int count = 0;
		res[count] = a[0];
		System.out.println(res[count]);
		for (int i = 1; i < a.length; i++) {
			if ((a[i] ^ a[i - 1]) != 0) {
				res[++count] = a[i];
				System.out.println(res[count]);
			}
		}
		return res;
	}
	
	public static void doTests() {
		int[] a = {
			1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9
		};
		removeDup(a);
	}
}
