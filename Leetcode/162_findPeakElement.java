
public class findPeakElement {
	
	// Time: O(logn), Space: O(1);
	public int findPeakElement (int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0, end = nums.length - 1;
		while (start < end) {
			int mid1 = start + (end - start) / 2;
			int mid2 = mid1 + 1;
			if (nums[mid2] > nums[mid1]) {
				start = mid2;
			} else {
				end = mid1;
			}
		}
		return start;
	}
}
