import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
	public List<List<Integer>> fourSum (int[] nums, int target) {
		
		List<List<Integer>> res = new ArrayList<>();
		int n = nums.length;
		// base case check 
		if (nums == null || n < 4)
			return res;
		
		// need to sort the array first in order to use the two pointer method;
		Arrays.sort(nums);
		
		// check if the number exists in the array;
		int max = nums[n - 1];
		if (4 * nums[0] > target || 4 * max < target)
			return res;
		
		for (int i = 0; i < n - 3; i++) {
			// the number does not exist
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
				break;
			// skip the number not under requirement
	        if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target)
	        		continue;
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < n - 2; j++) {
				
				if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) 
					break;
	            if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) 
	            		continue;
	            
	            // below is the same as the code in 3Sum problem
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int low = j + 1, high = n - 1;
				while (low < high) {
					int sum = nums[i] + nums[j] + nums[low] + nums[high];
					if (sum == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
						while(low < high && nums[low] == nums[low + 1])
							low++;
						while(low < high && nums[high] == nums[high] - 1)
							high--;
						low++;
						high--;
					} else if (sum < target)
						low++;
					else 
						high--;
				}
			}
		}
		return res;
	}
}
