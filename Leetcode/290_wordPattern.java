import java.util.HashMap;

public class wordPattern {
	
	// Time: O(n), Space: O(n);
	// use equals instead of !=
	// use != for Integer not int;
	public boolean wordPattern (String pattern, String str) {
		HashMap<Character, String> map = new HashMap<>();
		String[] res = str.split(" ");
		if (pattern.length() != res.length)
			return false;
		for (int i = 0; i < pattern.length(); i++) {
			if (!map.containsKey(pattern.charAt(i)))	{
				if (map.containsValue(res[i]))
					return false;
				map.put(pattern.charAt(i), res[i]);
			}
			else 
				if (!map.get(pattern.charAt(i)).equals(res[i]))
					return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		wordPattern test = new wordPattern ();
		System.out.println(test.wordPattern("abba", "cat dog dog cat"));
		String[] res = "cat dog dog cat".split(" ");
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
