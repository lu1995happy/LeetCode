import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class sentenceSimilarity {
	
	// Time: O(n * k), Space: O(n);
	public boolean areSentencesSimilar (String[] words1, String[] words2, String[][] pairs) {
		
		if (words1.length != words2.length)
			return false;
		HashMap<String, Set<String>> map = new HashMap<>();
	
		for (String[] pair : pairs) {
			if (!map.containsKey(pair[0]))
				map.put(pair[0], new HashSet<>());
			if (!map.containsKey(pair[1]))
				map.put(pair[1], new HashSet<>());
			map.get(pair[0]).add(pair[1]);
			map.get(pair[1]).add(pair[0]);		
		}
		
		for (int i = 0; i < words1.length; i++) {
			if (words1[i].equals(words2[i]))
				continue;
			if (!map.containsKey(words1[i]))
				return false;
			if (!map.get(words1[i]).contains(words2[i]))
				return false;
		}
		return true;
	}
	
	// Space: O(1);
	public boolean areSentencesSimilar2 (String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length)
			return false;
		for (int i = 0; i < words1.length; i++) {
			if (!isSimilar(words1[i], words2[i], pairs))
				return false;
		}
		return true;
	}
	
	public boolean isSimilar(String word1, String word2, String[][] pairs) {
		if (word1.equals(word2))
			return true;
		for (String[] pair : pairs) {
			if (pair[0].equals(word1) && pair[1].equals(word2))
				return true;
			if (pair[1].equals(word1) && pair[0].equals(word2))
				return true;
		}
		return false;
	}
}
