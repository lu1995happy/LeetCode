import java.util.HashMap;

public class subarraySumEqualsK {
    // Time: O(n), Space: O(n);
	// the key to solve this problem is sum[i, j]. So if we know sum[0, i - 1] and sum[0, j], then we can easily get 
	// sum[i, j]. To achieve this, we just need to go through the array, calculate the current sum and save number of
	// all seen PreSum to a HashMap. 
	public int subarraySum (int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0, result = 0;
		HashMap<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			result += preSum.getOrDefault(sum - k, 0);
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}
		return result;
	}
}
