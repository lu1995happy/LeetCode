import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class keyboardRow {
	
	public String[] findWords (String[] words) {
		List<String> res = new LinkedList<>();
		if (words == null || words.length == 0)
			return res.toArray(new String[0]);
		String[] strs = new String[] {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			for (char ch : strs[i].toCharArray()) 
				map.put(ch, i);
		}
		for (String word : words) {
			if (word == "")
				continue;
			boolean check = true;
			int val = map.get(word.toUpperCase().charAt(0));
			for (char ch : word.toUpperCase().toCharArray()) {
				if (map.get(ch) != val) {
					check = false;
					break;
				}
			}
			if (check) 
				res.add(word);
		}
		return res.toArray(new String[0]);
	}
}
