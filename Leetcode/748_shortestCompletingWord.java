
public class shortestCompletingWord {
	// Time: O(m * n), Space: O(1);
	public String shortestCompletingWord (String licensePlate, String[] words) {
		if (words == null || words.length == 0)
			return "";
		licensePlate = licensePlate.toLowerCase();
		int[] target = new int[26];
		for (char ch :licensePlate.toCharArray()) {
			if (Character.isLetter(ch)) {
				target[ch - 'a']++;
			}
		}
		String res = ""; 
		int minLength = Integer.MAX_VALUE;
		for (String word : words) {
			boolean found = true;
			int[] count = new int[26];
			for (char ch : word.toCharArray()) {
				count[ch - 'a']++;
			}
			for (int i = 0; i < 26; i++) {
				if (target[i] > 0 && target[i] > count[i]) {
					found = false;
					break;
				}
			}
			if (found && word.length() < minLength) {
				minLength = word.length();
				res = word;
			}
		}
		return res;
	}
}
