import java.util.ArrayList;
import java.util.List;

public class flipGame {
	
	// Time: O(n), Space: O(n);
	public List<String> generatePossibleNextMoves (String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0)
			return res;
		char[] ch = s.toCharArray();
		for (int i = 1; i < ch.length; i++) {
			if (ch[i] == '+' && ch[i - 1] == '+') {
				ch[i] = '-'; 
				ch[i - 1] = '-';
				res.add(String.valueOf(ch));
				ch[i] = '+';
				ch[i - 1] = '+';
			}
		}
		return res;
	}
}
