import java.util.ArrayList;
import java.util.List;

public class permutations {
	
	// Time: O(n * n!), Space: O(n);
	// The number of recursive calls, T(n) satisfies the recurrence T(n) = T(n - 1) + T(n - 2) + ... + T(1) + T(0), which solves 
	// to T(n) = O(2^n). Since we spend O(n) time within a call, the time complexity is O(n2^n);
	public List<List<Integer>> permute (int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		helper(res, nums, new ArrayList<>());
		return res;
	}
	
	public void helper(List<List<Integer>> res, int[] nums, List<Integer> list) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			// contains() takes O(n) time to process;
			if (list.contains(nums[i]))
				continue;
			list.add(nums[i]);
			helper(res, nums, list);
			list.remove(list.size() - 1);
		}
	}
	
	// Time: O(n!), Space: O(n);
	// skip using list.contains() function, keep swapping the array instead;
	public List<List<Integer>> permute2 (int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		helper(res, 0, nums);
		return res;
	}
	
	public void helper(List<List<Integer>> res, int start, int[] nums) {
		if (start == nums.length) {
			List<Integer> list = new ArrayList<>();
			for (int num : nums) {
				list.add(num);
			}
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			swap(nums, start, i);
			helper(res, start + 1, nums);
			swap(nums, start, i);
		}
	}
	
	public void swap (int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
