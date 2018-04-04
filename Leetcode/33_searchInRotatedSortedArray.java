
public class searchInRotatedSortedArray {
	
	// Time: O(logn), Space: O(1);
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		// start == end is the index of the smallest value and also the number of places rotated;
		int minIndex = findMin(nums);
		if (nums[minIndex] == target) 
			return minIndex;
		// change the start and end value based on the rotated position so that we can use binary search for each half;
		int start = target > nums[nums.length - 1] ? 0 : minIndex;
		int end = target > nums[nums.length - 1] ? minIndex: nums.length - 1;
		// The usual binary search and accounting for rotation;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
	
	// using binary search to find the rotated position;
	// find the index of the smallest value using binary search;
    // Loop will terminate since mid < end, and start or end will shrink by at least 1;
    // Proof by contradiction that mid < end: if mid == end, then start == end and loop would have been terminated;
	public int findMin (int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[end]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}
}
