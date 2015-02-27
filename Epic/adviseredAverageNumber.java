/*
 * Write a program to display the advisered average for the list of 
 * numbers my omitting the three largest number in the series.
 * E.g:3,6,12,55,289,600,534,900,172.  
 * avg = (3+6+12+55+289+172)/6 and eliminating 534,900,600
 */
public class adviseredAverageNumber {
	public static void main(String[] args) {
		doTests();
	}
	
	public static double average(int[] A) {
		if (A == null || A.length == 0) {
			return 0.0;
		}
		if (A.length <= 3) {
			return 0.0;
		}
		int count = A.length - 3;
		int sum = 0;
		int maxOne = 0;
		int maxTwo = 0;
		int maxThree = 0;
		for (int n : A) {
			if (maxOne < n) {
				maxThree = maxTwo;
				maxTwo = maxOne;
				maxOne = n;
			} else if (maxTwo < n) {
				maxThree = maxTwo;
				maxTwo = n;
			} else if (maxThree < n) {
				maxThree = n;
			}
			sum += n;
		}
		System.out.println("Three largest numbers are: " + maxOne + " " + maxTwo + " " + maxThree);
		return (double) (sum - maxOne - maxTwo - maxThree) / count;
	}
	
	public static void doTests() {
		int[] A = {3,6,12,55,289,600,534,900,172};
		double res = average(A);
		System.out.println(res);
	}
}
