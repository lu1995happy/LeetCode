import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class sortCharactersByFrequency {
	
	// bucket sort 
	// Time: O(n), Space: O(n);
	// similar to Leetcode 347
	public String frequencySort (String s) {
		if (s == null || s.length() == 0)
			return s;
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		List<Character>[] bucket = new List[s.length() + 1];
		for (char key : map.keySet()) {
			int freq = map.get(key);
			if (bucket[freq] == null) {
				bucket[freq] = new ArrayList<>();
			}
			bucket[freq].add(key);
		}
		StringBuilder sb = new StringBuilder();
		for (int pos = bucket.length - 1; pos >= 0; pos--) {
			if (bucket[pos] != null) {
				for (char ch : bucket[pos]) {
					for (int i = 0; i < pos; i++) {
						sb.append(ch);
					}
				}
			}
		}
		return sb.toString();
	}
	
	// Using PriorityQueue
    // Time: O(nlogn), Space: O(n);
	public String frequencySort2(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
	    }
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
			new Comparator<Map.Entry<Character, Integer>>() {
				@Override
	            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
					return b.getValue() - a.getValue();
	            }
	        }
		);
	    pq.addAll(map.entrySet());
	    StringBuilder sb = new StringBuilder();
	    while (!pq.isEmpty()) {
	    		Map.Entry e = pq.poll();
	        for (int i = 0; i < (int)e.getValue(); i++) {
	        		sb.append(e.getKey());
	        }
	    }
	    return sb.toString();
	}
}
