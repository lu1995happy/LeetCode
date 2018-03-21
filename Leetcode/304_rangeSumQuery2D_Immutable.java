
public class rangeSumQuery2D_Immutable {
	
	private int[][] dp;
	
	// Time: O(n * m); Space: O(n * m);
	// Based on : sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1]; 
	// sumRegion = sum[rMax + 1][cMax + 1] - sum[rMax + 1][cMin] - sum[rMin][cMax + 1] + sum[rMin][cMin]
	public rangeSumQuery2D_Immutable (int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
			return;
		int n = matrix.length;
		int m = matrix[0].length;
		dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1]; 
			}
		}
	}
	
	public int sumRegion(int row1, int col1, int row2, int col2) {
		int rMin = Math.min(row1,  row2);
		int rMax = Math.max(row1,  row2);
		int cMin = Math.min(col1,  col2);
		int cMax = Math.max(col1,  col2);
		return dp[rMax + 1][cMax + 1] - dp[rMax + 1][cMin] - dp[rMin][cMax + 1] + dp[rMin][cMin];
	}
}
