
public class maximumAverageSubarrayI {
	
	// Time: O(n), Space: O(1);
	public double findMaxAverage(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		long sum = 0, max = 0;
		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}
		max = sum;
		for (int i = k; i < nums.length; i++) {
			sum += nums[i] - nums[i - k];
			max = Math.max(sum, max);
		}
		return (double) max / k;
	}
}
