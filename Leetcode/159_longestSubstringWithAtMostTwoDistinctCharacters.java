import java.util.HashMap;

public class longestSubstringWithAtMostTwoDistinctCharacters {
	
	// Time: O(n), Space: O(n);
	// sliding window
	public int lengthOfLongestSubstringTwoDistinct (String s) {	
		if (s == null || s.length() == 0)
			return 0;
		int start = 0, end = 0;
		int res = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		while (end < s.length()) {
			if (map.size() <= 2) {
				map.put(s.charAt(end), end);
				end++;
			}
			if (map.size() > 2) {
				int leftMost = s.length(); 
				for (int num : map.values()) {
					leftMost = Math.min(leftMost, num);
				}
				map.remove(s.charAt(leftMost));
				start = leftMost + 1;
			}
			res = Math.max(res, end - start);
		}
		return res;
	}
}
