import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {
	
	// sorting way
	// Time: O(m * nlogn); Space: O(n);
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs == null || strs.length == 0)
			return res;
		HashMap<String, Integer> map = new HashMap<>();
		for (String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String s = new String(ch); // don't use String s = ch.toString();
			if (map.containsKey(s)) {
				List<String> list = res.get(map.get(s));
				list.add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(s, res.size());	
				res.add(list);
			}
		}
		return res;
	}
}
