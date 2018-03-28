
public class longestContinuousIncreasingSubsequence {
	
	// Time: O(n), Space: O(1);
	public int findLengthOfLCIS (int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int count = 1;
		int res = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1])
				count++;
			else 
				count = 1;
			res = Math.max(res, count);
		}
		return res;
	}
}
