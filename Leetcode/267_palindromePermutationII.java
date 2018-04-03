import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class palindromePermutationII {
	
	// Time: not sure, Space: O(n);
	public List<String> generatePalindromes (String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0)
			return res;
		// store the single character in the middle
		String mid = "";
		// count the odd characters
		int odd = 0;
		// step 1. build character count map and count odds
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			odd += map.get(ch) % 2 != 0 ? 1 : -1;
		}
		// cannot form any palindromic string
		if (odd > 1) 
			return res;
		List<Character> list = new ArrayList<>();
		// step 2. add half count of each character to list
		for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int freq = entry.getValue();
			if (freq % 2 == 1)
				mid = key + "";
			for (int i = 0; i < freq / 2; i++) {
				list.add(key);
			}
		}
		// step 3. generate all the permutations
		helper(res, new StringBuilder(), new boolean[list.size()], list, mid);
		return res;
	}
	
	// generate all unique permutation from list
	public void helper(List<String> res, StringBuilder sb, boolean[] used, List<Character> list, String mid) {
		if (sb.length() == list.size()) {
			// form the palindromic string			
			res.add(sb.toString() + mid + sb.reverse().toString());
			// reverse it back
			sb.reverse();
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			// avoid duplication			
			if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1])
				continue;
			// if not used
			if (!used[i]) {
				used[i] = true;
				sb.append(list.get(i));
				// recursion
				helper(res, sb, used, list, mid);
				// backtracking
				used[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
