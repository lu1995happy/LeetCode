import java.util.Arrays;

public class threeSumClosest {
	
	// Time: O(n^2), Space: O(1);
	// use 3 pointers to point current element, next element and the last element. 
	// If the sum is less than target, it means we have to add a larger element so next element move to the next. 
	// If the sum is greater, it means we have to add a smaller element so last element move to the second last element. 
	// Keep doing this until the end. Each time compare the difference between sum and target, if it is less than minimum 
	// difference so far, then replace result with it, otherwise keep iterating.
	public int threeSumClosest(int[] nums, int target) {
		
		if (nums.length == 3) 
			return nums[0] + nums[1] + nums[2];
		
		int res = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length - 2; i++) {
			int low = i + 1, high = nums.length - 1;
			while (low < high) {
				int sum = nums[low] + nums[high] + nums[i];
				if (Math.abs(target - sum) <= Math.abs(target - res)) {
					res = sum;
					if (sum == target)
						return target;
				} 
				if (target > sum)
					low++;
				else 
					high--;
			}
		}
		return res;
	}
}
