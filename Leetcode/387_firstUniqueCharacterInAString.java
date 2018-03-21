import java.util.HashMap;

public class firstUniqueCharacterInAString {
	
	// Array
	// Time: O(n), Space: O(n)
	public int firstUniqChar(String s) {
		
        if (s == null || s.length() == 0)
    			return -1;
        if (s.length() == 1)
    			return 0;
        
		int[] freq = new int[26];
		
		for (int i = 0; i < s.length(); i++) 
			freq[s.charAt(i) - 'a']++;

		
		for (int i = 0; i < s.length(); i++) {
			if (freq[s.charAt(i) - 'a'] == 1)
				return i;
		}
		
		return -1;
	}
	
	// HashMap 
	// Time: O(n), Space: O(n)
    public int firstUniqChar1(String s) {
        if (s == null || s.length() == 0)
        		return -1;
        if (s.length() == 1)
        		return 0;
        
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for (int i = 0; i < s.length(); ++i) 
        		freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
           
        for (int i = 0; i < s.length(); ++i) {
    			if (freq.get(s.charAt(i)) == 1) 
    				return i;
        }
        return -1;
    }
}
