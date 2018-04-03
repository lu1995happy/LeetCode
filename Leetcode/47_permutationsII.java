import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutationsII {
	
	// Time: O(n!), Space: O(n);
	// exactly same method used in Leetcode 267. Palindrome Permutation II;
	public List<List<Integer>> permuteUnique (int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		// sort the array to avoid duplicates;
		Arrays.sort(nums);
		// backtracking;
		helper(res, nums, new boolean[nums.length], new ArrayList<>());
		return res;
	}
	
	public void helper(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> list) {
		if (list.size() == nums.length) {
			// generate the result;
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			// skip the duplicate;
			if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
				continue;
			}
			if (!used[i]) {
				used[i] = true;
				list.add(nums[i]);
				// recursion;
				helper(res, nums, used, list);
				// backtracking;
				used[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}
}
