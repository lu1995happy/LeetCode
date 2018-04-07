
public class targetSum {
	
	// Time: O(n * S), Space: O(n);
	// The recursive solution is very slow, because its runtime is exponential
	// The original problem statement is equivalent to:
	// Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal 
	// to target	
	// Let P be the positive subset and N be the negative subset
	// For example:
	// Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
	// Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]
	// Then let’s see how this can be converted to a subset sum problem:

	// 	                 sum(P) - sum(N) = target
	// sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
    //                        2 * sum(P) = target + sum(nums)
	// So the original problem has been converted to a subset sum problem as follows:
	// Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2
	// Note that the above formula has proved that target + sum(nums) must be even
	// We can use that fact to quickly identify inputs that do not have a solution
	public int findTargetSumWays (int[] nums, int S) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum < S || -sum > S || (S + sum) % 2 != 0) {
			return 0;
		}
		return helper(nums, (S + sum) / 2);
	}
	
	public int helper(int[] nums, int S) {
		int[] dp = new int[S + 1];
		dp[0] = 1;
		for (int num : nums) {
			// decreasing j means we don't use any duplicate numbers;
			// for (int j = S; j >= num; j--) dp[j] += dp[j - num];
			// increasing j means we use duplicate numbers;
			// for (int j = num; j >= S; j++) dp[j] += dp[j - num]; 
			for (int j = S; j >= num; j--) {
				dp[j] += dp[j - num];
			}
		}
		return dp[S];
	}
	
	int res = 0;
	
	// Time: O(n * sum), Space: O(n);
	public int findTargetSumWays2 (int[] nums, int S) {
		if (nums == null || nums.length == 0) {
			return res;
		}
		// Optimization: The idea is If the sum of all elements left is smaller than absolute value of target, there 
		// will be no answer following the current path. Thus we can return.
		int[] sum = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			sum[i] = nums[i];
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			sum[i] += sum[i + 1];
		}
		dfs(nums, sum, 0, S);
		return res;
	}
	
	public void dfs (int[] nums, int[] sum, int pos, int target) {
		if (pos == nums.length) {
			if (target == 0) {
				res++;
			}
			return;
		}
		if (sum[pos] < Math.abs(target)) {
			return;
		}
		dfs(nums, sum, pos + 1, target - nums[pos]);
		dfs(nums, sum, pos + 1, target + nums[pos]);
	}
}
