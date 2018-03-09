
public class maximumSubarray {
	public int maxSubarray(int[] nums) {
		int maxCurr = nums[0], maxSoFar = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxCurr = Math.max(maxCurr + nums[i], nums[i]);
			maxSoFar = Math.max(maxCurr, maxSoFar);
		}
		return maxSoFar;
	}
}
