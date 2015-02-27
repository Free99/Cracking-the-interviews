import java.util.List;
import java.util.ArrayList;

/*
 * Suppose you want to do the subtraction of two numbers. Each digit of 
 * the numbers is divided and put in an array. Like A=[1,2, 3, 4, 5], 
 * B=[4, 5, 3, 5]. You should output an array C=[7, 8, 1, 0].Remember 
 * that your machine can’t hand numbers larger than 20.
 * 
 * http://www.cnblogs.com/superbo/p/4107320.html
 * 这里默认A比B大了，只做个思路哈，当然会有更复杂的情况比如是负数之类的，但是这里不做讨论和处理了。
 */

public class subtractionOfTwoArrays {
	public static void main(String[] args) {
		doTests();
	}
	
	public static List<Integer> substract(int[] a, int[] b) {
	    if(a == null || b == null)    return null;
	    List<Integer> res = new ArrayList<Integer>();
	    int ptr1 = a.length - 1;
	    int ptr2 = b.length - 1;
	    int carry = 0;
	    int diff = 0;
	    while(ptr1 >= 0 || ptr2 >= 0) {
	        if(ptr2 >= 0) {
	            diff = 10 + a[ptr1] - b[ptr2] - carry;
	            carry = diff/10 == 1 ? 0 : 1;
	            res.add(0, diff%10);
	            ptr2--;
	            ptr1--;
	        } else if(ptr1 >= 0) {
	        	if (carry != 0) {
	        		diff = a[ptr1] - carry;
	        		carry = 0;
	        		res.add(0, diff);
	        		ptr1--;
	        		if (diff == 0) {
	        			continue;
	        		}
	        	} else {
	        		res.add(0, a[ptr1]);
	        		ptr1--;
	        	}
	        }
	    }
	    return res;
	}
	
	public static void doTests() {
		int[] a = {2, 1, 2, 3, 4, 5};
		int[] b = {4, 5, 3, 5};
		System.out.println(substract(a, b));
	}
}
