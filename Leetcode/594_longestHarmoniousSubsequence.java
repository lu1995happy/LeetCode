import java.util.HashMap;

public class longestHarmoniousSubsequence {
	
	// Time: O(n), Space: O(n);
	public int findLHS (int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		for (int num : map.keySet()) {
			if (map.containsKey(num + 1)) {
				res = Math.max(res, map.get(num) + map.get(num + 1));
			}
		}
		return res;
	}
}
