
public class largestNumberAtLeastTwiceOfOthers {
	
	// Time: O(n), Space: O(1);
	// or use one iteration, record max and secondMax;
	public int dominantIndex (int[] nums) {		
		if (nums == null || nums.length == 0)
			return -1;
		int max = 0, res = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == max) {
				res = i;
			} else if (nums[i] * 2 > max) {
				return -1;
			}
		}
		return res;
	}
}
