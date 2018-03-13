
public class rotateArray {
	
	// 3 time reverse method
	// Time: O(n), Space: O(1);
	public void rotate(int[] nums, int k) {
	    if(nums == null || nums.length < 2)
	        return;

		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}
	
	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
	
	// new Array method
	// Time: O(n), Space: O(n);
	public void rotateArray(int[] nums, int k) {
		int[] tmp = nums.clone();
		for (int i = 0; i < nums.length; i++) {
			nums[(i + k) % nums.length] = tmp[i];
		}
	} 
}
