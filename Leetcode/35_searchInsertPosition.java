
public class searchInsertPosition{
	// find the first position that is >= target;
	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0 || nums == null) 
			return 0;
		int low = 0, high = nums.length;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] < target)
				low = mid + 1;
			else 
				high = mid;
		}
		return low;
	}
	
	public static void main(String[] args) {
		searchInsertPosition test = new searchInsertPosition();
		int[] nums = {1,3,4,5,6};
		System.out.println(test.searchInsert(nums, 0));
	}
}
