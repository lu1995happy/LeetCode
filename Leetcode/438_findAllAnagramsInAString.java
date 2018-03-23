import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findAllAnagramsInAString {
	
	// sliding window
	// Time: O(n), Space: O(n);
	public List<Integer> findAnagrams (String s, String p) {
		
		List<Integer> res = new ArrayList<>();
		if (s == null || p == null || s.length() < p.length())
			return res;
		int[] count = new int[26];
		for (char ch : p.toCharArray()) 
			count[ch - 'a']++;
		
		int start = 0, end = 0, len = p.length();
		while (end < s.length()) {
			if (end - start == p.length() && count[s.charAt(start++) - 'a']++ >= 0)
				len++;
			if (count[s.charAt(end++) - 'a']-- >= 1)
				len--;
			if (len == 0)
				res.add(start);
		}
		return res;
	}
	
	// using HashMap
	public List<Integer> findAnagrams2 (String s, String p) {
		// initiate a collection or Integer value to save the result according the question.
		List<Integer> res = new ArrayList<>();
		if (s == null || p == null || s.length() < p.length()) 
			return res;
		// create a HashMap to save the Characters of the target substring.
        // (K, V) = (Character, Frequency of the Characters)
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : p.toCharArray()) 
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		
		// Two Pointers: begin - left pointer of the window; end - right pointer of the window
		int start = 0, end = 0;
		// maintain a counter to check whether match the target string.
		// must be the map size, NOT the string size because the char may be duplicate.
		int len = map.size();
		// loop at the beginning of the source string
		while (end < s.length()) {
			// get a character
			char ch = s.charAt(end);
			if (map.containsKey(ch)) {
				// plus or minus one
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0)
					// modify the counter according the requirement(different condition).
					len--;	
			}
			end++;
			// increase begin pointer to make it invalid/valid again
			/* counter condition. different question may have different condition */
			while (len == 0) {
				//***be careful here: choose the char at begin pointer, NOT the end pointer
				char temp = s.charAt(start);
				if (map.containsKey(temp)) {
					// plus or minus one
					map.put(temp, map.get(temp) + 1);
					if (map.get(temp) > 0)
						// modify the counter according the requirement(different condition).
						len++;
				}
				/* save / update(min/max) the result if find a target*/
                // result collections or result Integer value
				if (end - start == p.length())
					res.add(start);
				start++;
			}
		}
		return res;
	}
}
