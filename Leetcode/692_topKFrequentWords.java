import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequentWords {
	
	// bucketSort
	// Time: O(n), Space: O(n);
	// similar as Leetcode 347. Top K Frequent Elements
	public List<String> topKFrequent (String[] words, int k) {
		List<String> res = new ArrayList<>();
		if (words == null || words.length == 0 || k <= 0) {
			return res;
		}
		HashMap<String, Integer> map = new HashMap<>();	
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		List<String>[] bucket = new List[words.length + 1];
		for (String word : map.keySet()) {
			int freq = map.get(word);
			if (bucket[freq] == null) {
				bucket[freq] = new ArrayList<>();
			}
			bucket[freq].add(word);
		}
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] != null) {
				// sort the bucket before output;
				// or we could generate a tire to sort the string;
				Collections.sort(bucket[i]);
			}
 		}
		for (int i = bucket.length - 1; i >= 0; i--) {
			int j = 0;
			while (bucket[i] != null && j < bucket[i].size() && k > 0) {
				res.add(bucket[i].get(j++));
				k--;
			}
		}
		return res;
 	}
	
	// PriorityQueue
	// Time: O(nlogk), Space: O(n);
	public List<String> topKFrequent2 (String[] words, int k) {
		List<String> res = new ArrayList<>();
		if (words == null || words.length == 0 || k <= 0) {
			return res;
		}
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> 
			// compareTo() makes the smallest string comes first;
			(a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()));
	
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			maxHeap.offer(entry);
			// make sure the size for maxHeap is less than or equal to k;
			if (maxHeap.size() > k) {
				// since the maxHeap is in increasing order, poll() will always remove the first element in the maxHeap;
				maxHeap.poll();
			}
		}
		while (!maxHeap.isEmpty()) {
			// maxHeap.poll() takes O(logk) time;
			Map.Entry<String, Integer> entry = maxHeap.poll();
			// since the smallest number comes first, we have to put each element in the first in order to get the decreasing;
			res.add(0, entry.getKey());
		}
		return res;
	}
}
