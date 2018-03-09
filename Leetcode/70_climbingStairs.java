
public class climbingStairs {
	
	// fibonacci similar problem
	// Time: O(2^n); Space: O(1);
	public int climbStairs (int n) {
		if (n <= 2)
			return n;
		return climbStairs(n - 1) + climbStairs(n - 2);
	}
	
	// Time: O(n); Space: O(1);
	public int climb(int n) {
		if (n == 1) 
			return n;
		int oneStep = 1, twoStep = 1, res = 0;
		for (int i = 2; i <= n; i++) {
			res = oneStep + twoStep;
			twoStep = oneStep;
			oneStep = res; 
		}
		return res;
	}
}
