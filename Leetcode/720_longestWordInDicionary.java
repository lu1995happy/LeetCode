import java.util.Arrays;
import java.util.HashSet;

public class longestWordInDicionary {
	
	// Time: O(nlogn), Space: O(n);
	public String longestWord (String[] word) {
		Arrays.sort(word);
		HashSet<String> set = new HashSet<>();
		String res = "";
		for (String w : word) {
			if (w.length() == 1 || set.contains(w.substring(0, w.length() - 1))) {
				res = w.length() > res.length() ? w : res;
				set.add(w);
			}
		}
		return res;
	}
}
