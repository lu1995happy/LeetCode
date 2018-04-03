
public class nextPermutation {
	// Time: O(n), Space: O(1);
	public void nextPermutation (int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		// from back of the array, find the first element that is in increasing order;
		int firstSmall = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				firstSmall = i;
				break;
			}
		}
		// if not found, means that the array is in decreasing order, so just need to reverse the array;
		if (firstSmall == -1) {
			reverse(nums, 0, nums.length - 1);
		}
		// if found, then we need to find the first element that is large than the firstSmall, swap them;
		for (int i = nums.length - 1; i > firstSmall; i--) {
			if (nums[i] > nums[firstSmall]) {
				int temp = nums[firstSmall];
				nums[firstSmall] = nums[i];
				nums[i] = temp;
				break;
			}
		}
		// then we have to make the part that after firstSmall increasing order;
		reverse(nums, firstSmall + 1, nums.length - 1);
		return;
	}
	
	public void reverse (int[] nums, int i, int j) {
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;	
			i++;
			j--;
		}
	}
}
