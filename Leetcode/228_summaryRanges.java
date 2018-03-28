import java.util.ArrayList;
import java.util.List;

public class summaryRanges {
	
	// Time: O(n), Space: O(n);
	public List<String> summaryRanges (int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
				i++;
			}
			if (num != nums[i])
				res.add(num + "->" + nums[i]);
			else 
				res.add(String.valueOf(num));
		}
		return res;
	}
}
