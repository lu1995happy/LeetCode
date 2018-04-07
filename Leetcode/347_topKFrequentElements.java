import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class topKFrequentElements {
	
	// PriorityQueue
	// Time: O(klogn), Space: O(n);
	public List<Integer> topKFrequent (int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0 || k <= 0) {
			return res;
		}
		// create a HashMap to store the <num, freq> pair;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		// create the pq that automatically sort the freq in decreasing order;
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			pq.add(entry);
		}
		while (res.size() < k) {
			// pq.poll() takes O(logn) time;
			Map.Entry<Integer, Integer> entry = pq.poll();
			res.add(entry.getKey());
		}
		return res;
	}
	
	// TreeMap
	// Time: O(klogn), Space: O(n);
	public List<Integer> topKFrequent2 (int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		if (k <= 0 || nums == null || nums.length == 0) {
			return res;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
		for (int num : map.keySet()) {
			int freq = map.get(num);
			if (!freqMap.containsKey(freq)) {
				freqMap.put(freq, new ArrayList<>());
			}
			freqMap.get(freq).add(num);
		}
		while (res.size() < k) {
			// TreeMap.poll() takes O(logn) time;
			Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
			res.addAll(entry.getValue());
		}
		return res;
	}
	
	// bucketSort
	// Time: O(n), Space: O(n);
	public List<Integer> topKFrequent3 (int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		if (k <= 0 || nums == null || nums.length == 0) {
			return res;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		List<Integer>[] bucket = new ArrayList[nums.length + 1];
		for (int num : map.keySet()) {
			int freq = map.get(num);
			if (bucket[freq] == null) {
				bucket[freq] = new ArrayList<>();
			}
			bucket[freq].add(num);
		}
		for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
			if (bucket[i] != null) {
				res.addAll(bucket[i]);
			}
		}
		/*
		for (int i = bucket.length - 1; i >= 0; i--) {
			int j = 0;
			while (bucket[i] != null && j < bucket[i].size() && k > 0) {
				res.add(bucket[i].get(j++));
				k--;
			}
		}
		*/
		return res;
	}
}
