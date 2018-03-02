
public class moveZeroes {
	
	// Time: O(n), Space: O(1);
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) 
			return;
		int current = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int tmp = nums[current];
				nums[current++] = nums[i];
				nums[i] = tmp;
			}
		}
	}
}
