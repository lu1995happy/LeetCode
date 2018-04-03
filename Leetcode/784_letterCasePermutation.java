import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class letterCasePermutation {
	
	// Time: O(2^n * n), Space: O(n);
	// backtracking;
	public List<String> letterCasePermutation (String s) {
		List<String> res = new ArrayList<>(Arrays.asList(s));
		if (s == null || s.length() == 0) {
			return res;
		}
		// traverse String s;
		for (int i = 0; i < s.length(); i++) {
			// s.charAt(i) > '9': letter, not digit.
			for (int j = 0, len = res.size(); s.charAt(i) > '9' && j < len; j++) {
				// transform to char[] the string @ j of res;
				char[] ch = res.get(j).toCharArray();
				// toggle case of charAt(i).
				ch[i] += ch[i] < 'a' ? 'a' - 'A' : 'A' - 'a';
				// ch[i] ^= (1 << 5); 
				// append to the end of ans.
				res.add(String.valueOf(ch));
			}
		}
		return res;
	}
}
