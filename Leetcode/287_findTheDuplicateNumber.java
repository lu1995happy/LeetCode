
public class findTheDuplicateNumber {
	
	// same as LinkedList cycle II
	// Time: O(n), Space: O(1);
	// two pointer;
	public int findDuplicate(int[] nums) {	
		if (nums == null || nums.length == 0 || nums.length == 1)
			return -1;
		int slow = nums[0];
		int fast = nums[nums[0]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		fast = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
	
	// binary search way
	// Time: O(nlogn), Space: O(1);
	public int findDuplicate2 (int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int count = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= mid)
					count++;
			}
			if (count > mid) {
				high = mid - 1;
			} else 
				low = mid + 1;
		}
		return low;
	}
	
	// another way to write 
	public int findDuplicate3 (int[] nums) {
		if (nums.length > 1) {
			int slow = 0;
			int fast = 0;
			while (true) {
				slow = nums[slow];
				fast = nums[nums[fast]];
				if (slow == fast) {
					fast = 0;
					while (slow != fast) {
						slow = nums[slow];
						fast = nums[fast];
					}
					return fast;
				}
			}
		} else 
			return -1;
	}
}
