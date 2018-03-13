import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
	
	// Time: O(n^2); Space: O(n);
	// method: two pointers;
	public List<List<Integer>> threeSum (int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length < 3)
			return res;
		// need to sort the array first in order to use the two pointer method;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			// skip the duplicate numbers
			if (i > 0 && nums[i] == nums[i - 1]) 
				continue;
			int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
			while (low < high) {
				// find the right answer
				if (nums[low] + nums[high] == sum) {
					res.add(Arrays.asList(nums[i], nums[low], nums[high]));
					// skip the duplicate numbers in the lower side
					while (low < high && nums[low] == nums[low + 1])
						low++;
					// skip the duplicate numbers in the upper side
					while (low < high && nums[high] == nums[high - 1])
						high--;
					low++;
					high--;
				} else if (nums[low] + nums[high] < sum) 
					low++;
				else 
					high--;
			}
		}
		return res;
	}
}
