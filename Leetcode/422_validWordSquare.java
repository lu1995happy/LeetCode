import java.util.List;

public class validWordSquare {
	
	// Time: O(m * n), Space: O(1);
	public boolean validWordSquare (List<String> words) {
		if (words == null || words.size() == 0)
			return true;
		if (words.get(0).length() != words.size()) 
			return false;
		for (int i = 0; i < words.size(); i++) {
			for (int j = 0; j < words.get(i).length(); j++) {
				if (j >= words.size() || i >= words.get(j).length() || words.get(i).charAt(j) != words.get(j).charAt(i))
					return false;
			}
		}
		return true;
	}
}
