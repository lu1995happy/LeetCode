
public class coinChange2 {
	
	// 0 - 1 knapsack problem
	// Time: O(n * amount); Space: O(amount);
	public int change (int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int num : coins) {
			// The difference is that if you update dp while:
			// increasing i then the previous partial result dp[i - coin] is the result that has considered coin already
			// decreasing i then the previous partial result dp[i - coin] is the result that has not considered coin yet
			for (int j = num; j <= amount; j++) {
				dp[j] += dp[j - num];
			}
		}
		return dp[amount];
	}
	
	// dp[i][j] : the number of combinations to make up amount j by using the first i types of coins
	// State transition:
	// 1. not using the ith coin, only using the first i-1 coins to make up amount j, then we have dp[i-1][j] ways.
	// 2. using the ith coin, since we can use unlimited same coin, we need to know how many way to make up amount 
	// j - coins[i] by using first i coins(including ith), which is dp[i][j-coins[i]]
	// Initialization: dp[i][0] = 1
	public int change2 (int amount, int[] coins) {
		int[][] dp = new int[coins.length + 1][amount + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= coins.length; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= amount; j++) {
				dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
			}
		}
		return dp[coins.length][amount];
	}
}
