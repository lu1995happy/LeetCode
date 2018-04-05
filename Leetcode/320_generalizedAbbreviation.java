import java.util.ArrayList;
import java.util.List;

public class generalizedAbbreviation {
	
	// backtracking
	// Time: O(2^n), Space: O(n);
	public List<String> generateAbbreviations (String word) {
		List<String> res = new ArrayList<>();
		dfs(res, word, new StringBuilder(), 0, 0);
		return res;
	}
	
	public void dfs(List<String> res, String word, StringBuilder sb, int pos, int count) {
		if (pos == word.length()) {
			if (count > 0) {
				sb.append(count);
			}
			res.add(sb.toString());
			return;
		} 
		
		// use number
		int len = sb.length();
		dfs(res, word, sb, pos + 1, count + 1);
		sb.setLength(len); // backtracking

		// use character
		len = sb.length();
		dfs(res, word, count > 0 ? sb.append(count).append(word.charAt(pos)): sb.append(word.charAt(pos)), pos + 1, 0);
		sb.setLength(len);
	}
}
