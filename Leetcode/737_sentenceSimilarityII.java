import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class sentenceSimilarityII {
	
	// dfs solution
	public boolean areSentencesSimilarTwo (String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length)
			return false;
		HashMap<String, HashSet<String>> map = new HashMap<>();
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
			if (!dfs(words1[i], words2[i], map, new HashSet<>()))
				return false;
		}
		return true;
	}
	
	public boolean dfs (String source, String target, HashMap<String, HashSet<String>> map, HashSet<String> visited) {
		if (map.get(source).contains(target))
			return true;
		visited.add(source);
		for (String next : map.get(source)) {
			if (!visited.contains(next) && dfs(next, target, map, visited))
				return true;
		}
		return false;
	}
	
	// union find solution
	// Time : O(nlogk + k) n is the length of max(words1, words2), k is the length of pairs, Space: O(k);
	public boolean areSentencesSimilarTwo2(String[] words1, String[] words2, String[][] pairs) {
		
		if (words1 == null || words2 == null || words1.length != words2.length)
			return false;

	    Map<String, String> map = new HashMap<String, String>();
	    for (String[] pair: pairs) {
	        String root1 = findRoot(map, pair[0]);
	        String root2 = findRoot(map, pair[1]);
	        if (!root1.equals(root2))
	            map.put(root1, root2);
	    }
	    
	    for (int i = 0; i < words1.length; i++) {
	        String root1 = findRoot(map, words1[i]);
	        String root2 = findRoot(map, words2[i]);
	        if (!root1.equals(root2))
	            return false;
	    }
	    
	    return true;
	}

	private String findRoot(Map<String, String> map, String word) {
	    String word1 = word;
	    String word2;
	    while(true) {
	        word2 = map.get(word1);
	        if (word2 == null)
	            return word1;
	        word1 = word2;
	    }
	}
}
