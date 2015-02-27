/*
 * Goldbach's conjecture : Every even integer greater than 2 
 * can be expressed as the sum of two primes. Write a function
 * which takes a number as input, verify if is an even number 
 * greater than 2 and also print at least one pair of prime numbers.
 */
public class twoPrimes {
	public static void main(String[] args) {
		doTests(12);
	}
	
	public static boolean isPrime(int n) {
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void doTests(int n) {
		if (n % 2 != 0) {
			System.out.println("Not an even number.");
		} else {
			for (int i = 1; i < n / 2; i++) {
				if (isPrime(i) && isPrime(n - i)) {
					System.out.println("For even number " + n + ", we have "
							+ "pair " + i + " and " + (n - i));
				}
			}
		}
	}
}
