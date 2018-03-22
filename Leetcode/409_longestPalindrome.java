import java.util.HashSet;
import java.util.Set;

public class longestPalindrome {
	
	// array
	// Time: O(n), Space: O(1);
	public int longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int res = 0;
		boolean bool = false;
		char[] count = new char[256];
		for (char ch : s.toCharArray()) {
			if (count[ch] > 0) {
				res++;
				count[ch]--;
			} else
				count[ch]++;
		}
		
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) 
				bool = true;
		}		
		if (bool)
			return 2 * res + 1;
		else 
			return 2 * res;
	}
	
	// HashSet
	// Time: O(n), Space: O(n)
	public int longestPalindrome2(String s) {
		if (s == null || s.length() == 0)
			return 0;
		
		int count = 0;
		Set<Character> set = new HashSet<>();
		
		for (char ch : s.toCharArray()) {
			if (set.contains(ch)) {
				set.remove(ch);
				count++;
			} else 
				set.add(ch);
		}
		
		if (set.size() != 0)
			return 2 * count + 1;
		else 
			return 2 * count;
	}
}
