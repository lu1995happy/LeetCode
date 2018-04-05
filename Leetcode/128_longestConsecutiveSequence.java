import java.util.HashSet;

public class longestConsecutiveSequence {
	
	// Time: O(n), Space: O(n);
	public int longestConsecutive (int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int res = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		for (int num : nums) {
			if (!set.contains(num - 1)) { // only check for one direction
				int up = num + 1;
				while (set.contains(up)) {
					up++;
				}
				res = Math.max(res, up - num);
			}
		}
		return res;
	}
}
