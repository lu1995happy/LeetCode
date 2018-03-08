
public class searchForARange {
	// binary search, Time: O(logn)
	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0 || nums == null)
			return new int[] {-1,-1};		
		return new int[] {findFirst(nums, target), findLast(nums,target)};
	}
	
	public int findFirst(int[] nums, int target) {
		if (nums[0] == target) 
			return 0;
		
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target && nums[mid - 1] < target)
				return mid;
			else {
				if (nums[mid] >= target) 
					// left half
					high = mid - 1;
				else 
					// right half
					low = mid + 1;
			}
		}
		return -1;
	}
	
	public int findLast(int[] nums, int target) {
		if (nums[nums.length - 1] == target) 
			return nums.length - 1;
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target && nums[mid + 1] > target)
				return mid;
			else {
				if (nums[mid] > target) 
					// left half
					high = mid - 1;
				else 
					// right half
					low = mid + 1;
			}
		}
		return -1;
	}
	
	public int[] searchForRange(int[] nums, int target) {
    		int[] result = new int[2];

    		int lo = searchStart(nums, target);
    		int hi = searchStart(nums, target + 1) - 1;

    		if (lo == nums.length || nums[lo] != target)	
    			return new int[]{-1, -1};

    		result[0] = lo;
    		result[1] = hi;

    		return result;
    }
	
    public int searchStart(int[] nums, int target) {
    		int lo = 0, hi = nums.length, mid;
    		while (lo < hi) {
    			mid = (lo + hi)/2;
    			if (nums[mid] < target) 
    				lo = mid + 1;
    			else 
    				hi = mid;
    		}
    		return lo;
    }
	
	public static void main(String[] args) {
		searchForARange test = new searchForARange();
		int[] nums = new int[] {5, 7, 7, 8, 8, 10};
		int[] res = test.searchRange(nums, 8);
		for (int n : res) 
			System.out.print(n + " ");
	}
}
