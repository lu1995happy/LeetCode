import java.util.HashMap;

import com.sun.jdi.IntegerType;

public class validWordAbbreviation {
	
	// Time: O(n), Space: O(1);
	public boolean validWordAbbreviation (String word, String abbr) {
		if (abbr == null || abbr.length() == 0 || abbr.length() > word.length()) {
			return false;
		}
		int i = 0, j = 0;
		while (i < word.length() && j < abbr.length()) {
			if (word.charAt(i) == abbr.charAt(j)) {
				i++;
				j++;
				continue;
			}
			if (abbr.charAt(j) <= '0' && abbr.charAt(j) > '9') {
				return false;
			}
			int start = j; 
			while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
				j++;
			}
			i += Integer.valueOf(abbr.substring(start, j));
		}
		return i == word.length() && j == abbr.length();
	}
	
	// Time: O(n), Space: O(n);
	public boolean validWordAbbreviation2 (String word, String abbr) {
		if (abbr == null || abbr.length() == 0 || abbr.length() > word.length()) {
			return false;
		}
		HashMap<Character, Integer> freq = new HashMap<>();
		for (char ch : word.toCharArray()) {
			freq.put(ch, freq.getOrDefault(ch, 0) + 1);
		}
		int len = 0, count = 0;
		for (char ch : abbr.toCharArray()) {
			if (Character.isDigit(ch)) {
				if (count == 0 && ch == '0')
					return false;
				count = count * 10 + Character.getNumericValue(ch);
			} else if (freq.containsKey(ch) && freq.get(ch) > 0) {
				len += count;
				count = 0;
				freq.put(ch, freq.get(ch) - 1);
				len++;
			} else {
				return false;
			}
		}
		return len + count == word.length();
	}
	
	public static void main(String[] args) {
		validWordAbbreviation test = new validWordAbbreviation();
		System.out.println(test.validWordAbbreviation("internationalization", "i12iz4n"));
	}
}
