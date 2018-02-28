import java.util.HashMap;

public class validAnagram {
	public boolean isAnagram(String s, String t) {
		
		if (s.length() != t.length()) {
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			if (map.containsKey(ch)) 
				map.put(ch, map.get(ch) + 1);
			else 
				map.put(ch, 1);
		}
		
		for (char ch: t.toCharArray()) {
			if (map.containsKey(ch) && map.get(ch) > 0)
				map.put(ch, map.get(ch) - 1);
			else 
				return false;
		}
		return true;
	}
	
	public boolean isvalidAnagram(String s, String t) {
		
		if (s.length() != t.length())
			return false;

		int[] res = new int['z' - 'a' + 1];
		
		for (char ch : s.toCharArray()) 
			res[ch - 'a'] ++;
	
		for (char ch : t.toCharArray()) {
			res[ch - 'a'] --;
			if (res[ch - 'a'] < 0) 
				return false;
		}
		return true;	
	}
	
	public static void main(String[] args) {
		validAnagram test = new validAnagram();
		System.out.println(test.isAnagram("car", "cat"));
		System.out.println(test.isAnagram("anagram", "nagaram"));
	}
}
