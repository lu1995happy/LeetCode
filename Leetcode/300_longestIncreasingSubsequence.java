import java.util.Arrays;

public class longestIncreasingSubsequence {
	
	// Time: O(nlogn), Space: O(n);
	public int lengthOfLIS (int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] tails = new int[nums.length];
		int res = 0;
		for (int num : nums) {
			int i = 0, j = res;
			while (i != j) {
				int mid = (i + j) / 2;
				if (tails[mid] < num) {
					i = mid + 1;
				} else {
					j = mid;
				}
			}
			tails[i] = num;
			if (i == res) 
				res++;
		}
		return res;
	}
	
	
	// Time: O(n^2), Space: O(n);
	public int lengthOfLIS2 (int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int res = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					res = Math.max(res, dp[i]);
				}
			}
		}
		return res;
	}
}
