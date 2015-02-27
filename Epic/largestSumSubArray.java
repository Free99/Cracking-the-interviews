import java.util.List;
import java.util.ArrayList;

/*
 * Find thelargest sum contiguous sub array. The length of 
 * the returned sub array must beat least of length 2.
 * 
 * Similar to https://oj.leetcode.com/problems/maximum-subarray/
 */

public class largestSumSubArray {
	public static void main(String[] args) {
		doTests();
	}
	
	public static String maxSubArray(int[] A) {
		List<Integer> res = new ArrayList<Integer>();
		if (A == null || A.length == 0) {
			return "";
		} 
		res.add(A[0]);
		int curSum = 0;
		int max = A[0];
		String ans = new String();
		for (int i = 1; i < A.length; i++) {
			if (curSum < 0) {
				curSum = A[i];
				res = new ArrayList<Integer>();
				res.add(A[i]);
			} else {
				curSum += A[i];
				res.add(A[i]);
			}
			if (max < curSum) {
				max = curSum;
				ans = res.toString();
			}
		}
		return ans;
	}
	
	public static void doTests() {
		int[] array = {
			-2, 1, -3, 4, -1, 2, 1, -5, 4
		};
		String res = maxSubArray(array);
		if (res.length() >= 2) {
			System.out.println(res);
		} else {
			System.out.println("The return length is shorter than 2.");
		}
	}
}
