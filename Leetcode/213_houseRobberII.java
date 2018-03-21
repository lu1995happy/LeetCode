
public class houseRobberII {
	
	// Dynamic Programming solution
	// Time: O(n), Space: O(1);
	// Same as the previous house Robber problem; 
	// If all the houses are arranged in a circle, then we just have to convert this problem into 2 situations;
	// one is rob the first house and ignore the last house, the other is not rob the first house and rob the last house;
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	public int rob(int[] nums, int low, int high) {
		// max money can get if not rob current house
		int ifRobbedPrevious = 0;
		// max money can get if rob current house
		int ifDidntRobPrevious = 0;
		// We go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
		for (int i = low; i <= high; i++) {
			// If we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
			int currRobbed = ifDidntRobPrevious + nums[i];
			// If we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
			int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious); 
			// Update values for the next round
			ifDidntRobPrevious  = currNotRobbed;
	        ifRobbedPrevious = currRobbed;
		}
		return Math.max(ifDidntRobPrevious, ifRobbedPrevious);
	}
}
