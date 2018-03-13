import java.util.HashMap;

public class isomorphicStrings {
	
	// faster 2 ms array method
	// use same idea as HashMap
	public boolean checkString(String s, String t) {
		if (s.equals(t))
			return true;
		boolean[] visited = new boolean[256];
		char[] map = new char[256];
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		for (int i = 0; i < sc.length; i++) {
			if (map[sc[i]] == 0) {
				if (visited[tc[i]])
					return false;
				map[sc[i]] = tc[i];
				visited[tc[i]] = true;
			} else {
				if (map[sc[i]] != tc[i])
					return false;
			}
		}
		return true;
	}
	
	// Array method
	// Time: O(n), Space: O(1)
	public boolean check(String s, String t) {
		if (s.length() != t.length())
			return false;
		if (s == null || t == null)
			return true;
		char[] sChar = new char[256];
		char[] tChar = new char[256];
		
		for (int i = 0; i < s.length(); i++) {	
			if (sChar[s.charAt(i)] != tChar[t.charAt(i)])
				return false;
			else 
				sChar[s.charAt(i)] = tChar[t.charAt(i)] = t.charAt(i);
		}
		return true;
	}

	// HashMap method
	// Time: O(n^2), Space: O(n);
	public boolean isIsomorphic (String s, String t) {
		if (s.length() != t.length())
			return false;
		if (s == null || t == null)
			return true;
		HashMap<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);
			if (map.containsKey(a)) {
				if (map.get(a).equals(b)) 
					continue;
				else 
					return false;
			} else {
				// time: O(n)
				if (!map.containsValue(b))
					map.put(a, b);
				else 
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		isomorphicStrings test = new isomorphicStrings();
		System.out.println(test.isIsomorphic("egg", "add"));
		System.out.println(test.isIsomorphic("foo", "bar"));
		System.out.println(test.isIsomorphic("paper", "title"));
		System.out.println(test.isIsomorphic("ab", "aa"));
	}
}
