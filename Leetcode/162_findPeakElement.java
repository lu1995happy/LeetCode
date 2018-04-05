
public class findPeakElement {
	
	// Time: O(logn), Space: O(1);
	// Lets say you have a mid number at index x, nums[x]
	// if (num[x+1] > nums[x]), that means a peak element HAS to exist on the right half of that array, because 
	// (since every number is unique) 1. the numbers keep increasing on the right side, and the peak will be the last element.
	// 2. the numbers stop increasing and there is a ‘dip’, or there exists somewhere a number such that nums[y] < nums[y-1], 
	// which means number[x] is a peak element.
	// This same logic can be applied to the left hand side (nums[x] < nums[x-1]).
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
