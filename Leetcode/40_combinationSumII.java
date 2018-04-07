import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSumII {
	
	// Time: O(2^n), Space: O(2^n);
	// the only difference between combinationSum is that II contains duplicate numbers in the array, so that we need to 
	// sort the array first in order to skip the duplicate numbers;
	public List<List<Integer>> combinationSum2 (int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates); // in order to skip duplicate numbers;
		dfs(res, new ArrayList<>(), candidates, target, 0, 0);
		return res;
	}
	
	public void dfs (List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int index, int sum) {
		if (sum == target) {
			res.add(new ArrayList<>(list));
		}
		if (sum > target) {
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (i > index && candidates[i] == candidates[i - 1]) { // skip duplicates;
				continue;
			}
			if (candidates[i] <= target) {
				list.add(candidates[i]);
				dfs(res, list, candidates, target, i + 1, sum + candidates[i]);
				list.remove(list.size() - 1);
			}
		}
	}
}
