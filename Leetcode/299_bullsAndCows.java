import java.util.HashMap;

public class bullsAndCows {
	
	// Array method
	// Time: O(n), Space: O(1);
	public String getHints(String secret, String guess) {
		// table records the appearance of a digit
	    // digit from secret will increase the counter
	    // digit from guess will decrease the counter
		int[] nums = new int[10];
		int bull = 0, cow = 0;
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) 
				// accurate match (same digit with same position)
				bull++;
			else {
				// if prev part of guess has curr digit in secret
	            // then we found a pair that has same digit with different position
				if (nums[secret.charAt(i) - '0']++ < 0)
					cow++;
				// if prev part of secret has curr digit in guess
	            // then we found a pair that has same digit with different position  
				if (nums[guess.charAt(i) - '0']-- > 0) 
					cow++;
			}
		}
		return new String(String.valueOf(bull) + "A" + String.valueOf(cow) + "B");
	}
	
	// HashMap method
	// Time: O(n), Space: O(n);
	public String getHint(String secret, String guess) {
		HashMap<Character, Integer> check = new HashMap<>();
		String res = "";
		int countBull = 0, countCow = 0;
		for (int i = 0; i < secret.length(); i++) {
			char ch = secret.charAt(i);
			check.put(ch, check.getOrDefault(ch, 0) + 1);
		}
		for (int i = 0; i < secret.length(); i++) {
			char ch1 = secret.charAt(i), ch2 = guess.charAt(i);
			if (ch1 == ch2) {
				countBull++;
				check.put(ch2, check.get(ch2) - 1);
			} 
		}
		for (int i = 0; i < secret.length(); i++) {
			char ch1 = secret.charAt(i), ch2 = guess.charAt(i);
			if (ch1 != ch2)
				if (check.get(ch2) != null && check.get(ch2) > 0) {
					countCow++;
					check.put(ch2, check.get(ch2) - 1);
				}
		}
			
		res = String.valueOf(countBull) + "A" + String.valueOf(countCow) + "B";
		return res;
	}
	
	public static void main(String[] args) {
		bullsAndCows test = new bullsAndCows();
		System.out.println(test.getHint("1122", "1222"));
	}
}
