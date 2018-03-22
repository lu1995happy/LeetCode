
public class findTheDifference {
	
	// bit manipulation
	// Time: O(n), Space: O(1)
	// ^ same = 0, different = 1;
	public char findTheDifference (String s, String t) {
		int n = s.length();
		char ch = t.charAt(n);
		for (int i = 0; i < n; i++) {
			ch ^= s.charAt(i);
			ch ^= t.charAt(i);
		}
		return ch;
	}
	
	// charIndex
	public char findTheDifference2 (String s, String t) {
		int res = t.charAt(s.length());
		for (int i = 0; i < s.length(); i++) {
			res -= s.charAt(i);
			res += t.charAt(i);
		}
		return (char)res;
	}
	
	// array
	public char findTheDifference3 (String s, String t) {
		int[] res = new int[26];
		char ch = ' ';
		for (int i = 0; i < s.length(); i++) 
			res[s.charAt(i) - 'a']++;
		for (int i = 0; i < t.length(); i++) {
			if (res[t.charAt(i) - 'a'] <= 0) {
				ch = t.charAt(i);
				break;
			}
			res[t.charAt(i) - 'a']--;
		}
		return ch;
	}
}
