import java.text.DecimalFormat;

/*
 * The hit rate of the basketball game is given by the number of hits 
 * divided by the number of chances. For example, you have 73 chances but
 * hit 15 times, then your hit rate is 15/73=0.205 (keep the last3 digits).
 * On average, you have 4.5 chances in each basketball game. Assume the total
 * number of games is 162. Write a function for a basketball player. He will input 
 * the number of hits he has made, the number of chances he had, and the number 
 * of remaining games. The function should return the number of future hits, 
 * so that he can refresh his hit rate to 0.45
 */

public class basketballHitRate {
	public static void main(String[] args) {
		doTests();
	}
	
	public static double refresh(int h, int c, int r) {
		double curHitsRate = (double) h / c;
		double futureHits = 0;
		futureHits = 4.5 * (0.45 * 162 - curHitsRate * (162 - r));
		DecimalFormat df = new DecimalFormat("0.000");
		String s = df.format(futureHits);
		futureHits = Double.parseDouble(s);
		return futureHits;
	}
	
	public static void doTests() {
		int h = 10;
		int c = 30;
		int r = 62;
		System.out.println(refresh(h, c, r));
	}
}
