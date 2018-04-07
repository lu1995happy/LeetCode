
public class uniquePaths {
	
	// dynamic programming
	// Time: O(m * n), Space: O(m * n);
	// This is a fundamental DP problem. First of all, let’s make some observations.
	// Since the robot can only move right and down, when it arrives at a point, there are only two possibilities:
	// It arrives at that point from above (moving down to that point);
	// It arrives at that point from left (moving right to that point).
	// Thus, we have the following state equations: suppose the number of paths to arrive at a point (i, j) is denoted 
	// as P[i][j], it is easily concluded that P[i][j] = P[i - 1][j] + P[i][j - 1].
	// The boundary conditions of the above equation occur at the leftmost column (P[i][j - 1] does not exist) and the 
	// uppermost row (P[i - 1][j] does not exist). These conditions can be handled by initialization 
	// (pre-processing) — initialize P[0][j] = 1, P[i][0] = 1 for all valid i, j. Note the initial value is 1 instead of 0!
	public int uniquePaths (int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			res[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			res[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				res[i][j] = res[i - 1][j] + res[i][j - 1];
			}
		}
		return res[m - 1][n - 1];
	}
	
	// Time: O(m * n), Space: O(n);
	// the difference is scan line by line instead of scanning the whole matrix;
	// We only need to store the previous row/column to perform the calculation for the next one. So an 1-d array 
	// would suffice. You could also choose to iterate through m or n depending on which direction you choose to 
	// go (by row or by column). Note that the first element of the array will always be 1.
	public int uniquePaths2 (int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				res[j] = res[j] + res[j - 1];
			}
		}
		return res[n - 1];
	}
	
	// Time: O(m), Space: O(1);
	// If you mark the south move as ‘1’ and the east move as ‘0’. This problem shall be equal to :
	// Given (m+n-2) bits. you can fill in ‘1’ for (m-1) times and ‘0’ for (n-1) times, what is the number of different 
	// numbers? the result is clear that the formula shall be C(m-1)(m+n-2), where m-1 is the superscript behind C 
	// and m+n-2 is the subscript behind C.
	// First of all you should understand that we need to do n + m - 2 movements : m - 1 down, n - 1 right, because we 
	// start from cell (1, 1). Secondly, the path it is the sequence of movements( go down / go right),
	// therefore we can say that two paths are different
	// when there is i-th (1 … m + n - 2) movement in path1 differ i-th movement in path2.
	// So, how we can build paths.
	// Let’s choose (n - 1) movements(number of steps to the right) from (m + n - 2),
	// and rest (m - 1) is (number of steps down).
	// I think now it is obvious that count of different paths are all combinations (n - 1) movements from (m + n-2).
	public int uniquePaths3 (int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int count = m + n - 2; // how much steps we need to do
		int k = m - 1; // number of steps that need to go down
		double res = 1;
		// here we calculate the total possible path number 
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
		for (int i = 1; i <= k; i++) {
			res = res * (count - k + i) / i;
		}
		return (int) res;
	}
}
