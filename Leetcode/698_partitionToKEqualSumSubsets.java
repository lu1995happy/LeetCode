
public class partitionToKEqualSumSubsets {
	
	// backtracking;
	// Time: O(2^n), Space: O(2^n);
	public boolean canPartitionKSubsets (int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % k != 0) {
			return false;
		}
		return dfs(nums, k, new boolean[nums.length], sum / k, 0, 0);
	}
	
	public boolean dfs(int[] nums, int k, boolean[] visited, int target, int index, int sum) {
		if (k == 1) {
			return true;
		}
		if (sum == target) {
			return dfs(nums, k - 1, visited, target, 0, 0);
		}
		for (int i = index; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (dfs(nums, k, visited, target, i + 1, sum + nums[i])) {
					return true;
				}
				visited[i] = false;
			}
		}
		return false;
	}
}
