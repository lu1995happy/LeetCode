
public class productOfArrayExceptSelf {
	
	// Time: O(n), Space: O(n);
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		if (nums == null || nums.length == 0) {
			return nums;
		}
		res[0] = 1;
		// calculate the product of left side of itself;
		for (int i = 1; i < nums.length; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		int right = 1;
		// calculate the product of right side of itself;
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}
}
