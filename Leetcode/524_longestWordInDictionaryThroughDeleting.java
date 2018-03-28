import java.util.Arrays;
import java.util.List;

public class longestWordInDictionaryThroughDeleting {
	
	// Time: O(n * k), where n is the length of string s and k is the number of words in the dictionary. Space: O(1);
	// without sorting;
	public String findLongestWord (String s, List<String> d) {
		
		if (s == null || s.length() == 0)
			return "";
		String res = "";
		for (String word : d) {
			int i = 0;
			for (char ch : s.toCharArray()) {
				if (i < word.length() && ch == word.charAt(i)) {
					i++;
				}
			}
			if (i == word.length() && word.length() >= res.length()) {
				if (word.length() > res.length() || word.compareTo(res) < 0)
					res = word;
			}
		}
		return res;
	}
	
	// Time: O(nlogn + n * k), Space: O(1);
	// sorting and two pointers;
	public String findLongestWord2 (String s, List<String> d) {
		
		if (s == null || s.length() == 0)
			return "";
		String res = "";
		String[] dic = d.toArray(new String[0]);
		Arrays.sort(dic);
		for (String word : dic) {
			int s1 = 0, s2 = 0;
			while (s2 < word.length() && s1 < s.length()) {
				if (word.charAt(s2) == s.charAt(s1)) {
					s1++;
					s2++;
				} else 
					s1++;
			}
			if (s2 == word.length())
				res = word.length() > res.length() ? word : res;
		}
		return res;
	}
}
