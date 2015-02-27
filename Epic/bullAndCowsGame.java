import java.util.Map;
import java.util.HashMap;

/*
 * There’s a word guessing game. One person think a word, and the other 
 * one guess a word, both words have the same length.The person should 
 * return the number of bulls and cows for the guessing. Bulls represent 
 * the number of same characters in the same spots, whereas cows represent 
 * the number of characters guessed right but in the wrong spots. Write a 
 * program with two input strings, return the number of bulls and cows.
 */

public class bullAndCowsGame {
	public static void main(String[] args) {
		doTests();
	}
	
	public static void wordCheck(String guess, String ans) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < ans.length(); i++) {
			if (!map.containsKey(ans.charAt(i))) {
				map.put(ans.charAt(i), 1);
			} else {
				map.put(ans.charAt(i), map.get(ans.charAt(i)) + 1);
			}
		}
		
		int bulls = 0;
		int cows = 0;
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) == ans.charAt(i)) {
				bulls++;
				map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
			} else if (map.containsKey(guess.charAt(i)) 
				    && map.get(guess.charAt(i)) != 0) {
				cows++;
				map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
			}
		}
		
		System.out.println("Bulls: " + bulls + ", cows: " + cows);
	}
	
	public static void doTests() {
		String str1 = "dusts";
		String str2 = "studs";
		wordCheck(str1, str2);
	}
}
