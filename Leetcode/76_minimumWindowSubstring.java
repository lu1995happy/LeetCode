import java.util.HashMap;

public class minimumWindowSubstring {
	
	// sliding window
	// Time: O(n), Space: O(n);
	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() < t.length()) 
			return "";
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : t.toCharArray()) 
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		int start = 0, end = 0, counter = map.size(), len = Integer.MAX_VALUE, head = 0;
		while (end < s.length()) {
			char ch = s.charAt(end);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0)
					counter--;
			}
			end++;
			while (counter == 0) {
				char temp = s.charAt(start);
				if (map.containsKey(temp)) {
					map.put(temp, map.get(temp) + 1);
					if (map.get(temp) > 0)
						counter++;
				}
				if (end - start < len) {
					len = end - start;
					head = start;
				}
				start++;
			}
 		}
		if (len == Integer.MAX_VALUE) 
			return "";
		return s.substring(head, head + len);
	}
}
