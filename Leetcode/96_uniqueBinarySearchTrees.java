
public class uniqueBinarySearchTrees {
	// Time: O(n^2), Space: O(n);
	// dp[0] = 1
	// dp[1] = 1
	// dp[2] = dp[0] * dp[1] + dp[1] * dp[0] = 1 + 1 = 2
	// dp[3] = dp[0] * dp[2] + dp[1] * dp[1] + dp[2] * dp[0] = 2 + 1 + 2 = 5
	// dp[4] = dp[0] * dp[3] + dp[1] * dp[2] + dp[2] * dp[1] + dp[3] * dp[0] = 5 + 2 + 2 + 5 = 14
	// dp[n] = dp[0] * dp[n - 1] + dp[1] * dp[n - 2] +...+ dp[n - 2] * dp[1] + dp[n - 1] * dp[0]
	// Just treat each number as root, and then left part * right part is the answer.
	public int numTrees (int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		return dp[n];
	}
}
