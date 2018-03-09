import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class longestSubstringWithoutRepeatingCharacters {
	
	// Time: O(n); Space: O(n);
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		HashMap<Character,Integer> map = new HashMap<>();
		int res = 0;
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i)))
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			map.put(s.charAt(i), i);
			res = Math.max(res, i - j + 1);
		}
		return res;
	}
	
	// Sliding window like solution using HashSet
	public int longestLength(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Set<Character> set = new HashSet<>();
		int i = 0, j = 0, res = 0;
		while (j < s.length()) {
			if (set.contains(s.charAt(j))) {
				set.remove(s.charAt(i++));
			} else {
				set.add(s.charAt(j++));
				res = Math.max(res, set.size());
			}
		}
		return res;
	}
	
	// Substring problem using Kadane's algorithm
	// Time: O(n), Space: O(1);
	public int LongestSubstring(String s) {
        int lastIndices[] = new int[256];
        for(int i = 0; i<256; i++){
            lastIndices[i] = -1;
        }
        
        int maxLen = 0;
        int curLen = 0;
        int start = 0;
        int bestStart = 0;
        for(int i = 0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(lastIndices[cur]  < start){
                lastIndices[cur] = i;
                curLen++;
            }
            else{
                int lastIndex = lastIndices[cur];
                start = lastIndex+1;
                curLen = i-start+1;
                lastIndices[cur] = i;
            }
            
            if(curLen > maxLen){
                maxLen = curLen;
                bestStart = start;
            }
        }
        
        return maxLen;
    }
}
