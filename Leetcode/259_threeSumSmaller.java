import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSumSmaller {
	
	// Time: O(n^2); Space: O(1);
	// method: two pointers;
	public int threeSumSmaller (int[] nums, int target) {
		if (nums.length < 3)
			return 0;
		int count = 0;
		// need to sort the array first in order to use the two pointer method;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int low = i + 1, high = nums.length - 1;
			while (low < high) {
				// find the right answer
				if (nums[low] + nums[high] + nums[i] < target) {
					// all elements in [low, high] should satisfied the requirement;
					count += high - low;
					low++;
				} 
				else 
					high--;
			}
		}
		return count;
	}
}	
			
