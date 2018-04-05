import java.util.Arrays;

public class numberOfLongestIncreasingSubsequence {
	
	// Time: O(n^2), Space: O(n);
	public int findNumberOfLIS (int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		// len[i] : the length of the Longest Increasing Subsequence which ends with nums[i].
		int[] len = new int[nums.length];
		// count[i] : the number of the Longest Increasing Subsequence which ends with nums[i].
		int[] count = new int[nums.length];
		Arrays.fill(len, 1);
		Arrays.fill(count, 1);
		int res = 0, maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (len[i] == len[j] + 1) {
						count[i] += count[j];
					}
					if (len[i] < len[j] + 1) {
						len[i] = len[j] + 1;
						count[i] = count[j];
					}
				}
			}
			if (maxLength == len[i]) {
				res += count[i];
			}
			if (maxLength < len[i]) {
				maxLength = len[i];
				res = count[i];
			}
		}
		return res;
	}
}
