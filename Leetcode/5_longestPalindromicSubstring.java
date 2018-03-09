
public class longestPalindromicSubstring {
	public int low, maxLen;
	
	// Time: O(n^2), Space: O(1);
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 2) 
			return s;
		for (int i = 0; i < s.length(); i++) {
			// assume odd length, try to extend Palindrome as possible
			extendPalindrome(s, i, i);
			// assume even length
			extendPalindrome(s, i, i+1);
		}
		return s.substring(low, low + maxLen);
	}
	
	public void extendPalindrome(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		if (maxLen < right - left - 1) {
			low = left + 1;
			maxLen = right - left - 1;
		}
	}
	
	// dp solution
	// Time: O(n^2); Space: O(n^2);
	public String searchPalindrome(String s) {
		if (s == null || s.length() < 2) 
			return s;
		
		boolean[][] dp = new boolean[s.length()][s.length()];
		String res = "";
		int max = 0;
		
		for (int j = 0; j < s.length(); j++) {
			for (int i = 0; i <= j; i++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1]);
				if (dp[i][j]) {
					if (max < j - i + 1) {
						max = j - i + 1;
						res = s.substring(i, j + 1);
					}
				}
			}
		}
		return res;
	}
}
