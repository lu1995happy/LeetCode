
public class houseRobber {
	
	// Dynamic Programming solution
	// Time: O(n), Space: O(1);
	public int rob(int[] nums) {
		// max money can get if not rob current house
		int ifRobbedPrevious = 0;
		// max money can get if rob current house
		int ifDidntRobPrevious = 0;
		// We go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
		for (int num : nums) {
			// If we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
			int currRobbed = ifDidntRobPrevious + num;
			// If we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
			int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious); 
			// Update values for the next round
			ifDidntRobPrevious  = currNotRobbed;
	        ifRobbedPrevious = currRobbed;
		}
		return Math.max(ifDidntRobPrevious, ifRobbedPrevious);
	}
	
	// Dynamic Programming solution
	// Time: O(n), Space: O(n);
	public int countRob(int[] nums) {
		int[][] dp = new int[nums.length + 1][2];
		for (int i = 1; i <= nums.length; i++) {
			// dp[i][0] means we don’t rob the current house
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			// dp[i][1] means we rob the current house
			dp[i][1] = nums[i - 1] + dp[i - 1][0];
		}
		return Math.max(dp[nums.length][0], dp[nums.length][1]);
	}
}
