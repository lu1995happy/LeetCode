import java.util.Arrays;

public class shortestUnsortedContinuousSubarray {
	
	// Time: O(n), Space: O(1);
	public int findUnsortedSubarray (int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		int i = 0, j = -1;
		for (int left = 0, right = nums.length - 1; right >= 0; left++, right--) {
			max = Math.max(max, nums[left]);
			if (nums[left] != max) {
				j = left;
			}
			min = Math.min(min, nums[right]);
			if (nums[right] != min) {
				i = right;
			}
		}
		return j - i + 1;
	}	
	
	// Time: O(nlogn), Space: O(n);
	public int findUnsortedSubarray2 (int[] nums) {
		int[] sort = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sort);
		int start = 0, end = nums.length - 1;
		int res = nums.length;
		while (start <= end) {
			if (nums[start] == sort[start]) {
				start++;
				res--;
			} else if (nums[end] == sort[end]) {
				end--;
				res--;
			} else {
				break;
			}
		}
		return res;
	}
}
