import java.util.Arrays;

public class perfectSquares {
	
	// Time: O(n * sqrt(n)), Space: O(n);
	/*
	 * dp[0] = 0 
	   dp[1] = dp[0]+1 = 1
	   dp[2] = dp[1]+1 = 2
	   dp[3] = dp[2]+1 = 3
	   dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 } 
	   = Min{ dp[3]+1, dp[0]+1 } 
       = 1				
	   dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 } 
       = Min{ dp[4]+1, dp[1]+1 } 
       = 2
				.
				.
				.
	   dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
       = Min{ dp[12]+1, dp[9]+1, dp[4]+1 } 
       = 2
				.
				.
				.
	   dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
	 */
	public int numSquares (int n) {
		if (n < 1)
			return 0;
		int[] res = new int[n + 1];
		Arrays.fill(res, Integer.MAX_VALUE);
		res[0] = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = 1; j * j <= n; j++) {
				res[i] = Math.min(res[i], res[i - j * j] + 1);
			}
		}
		return res[n];
	}
	
	// Math
	// Time: O(logn), Space: O(1);
	public int numSquares2(int n) {
	    while (n % 4 == 0)
	        n /= 4;
	    if (n % 8 == 7)
	        return 4;
	    for (int a = 0; a * a <= n; ++a) {
	        int b = (int) Math.sqrt(n - a * a);
	        if (a * a + b * b == n)
	            return a == 0 ? 1 : 2;
	    }
	    return 3;
	}
}
