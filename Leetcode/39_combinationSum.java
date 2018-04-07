import java.util.ArrayList;
import java.util.List;

public class combinationSum {
	
	// Time: O(2^n), Space: O(2^n);
	public List<List<Integer>> combinationSum (int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		dfs(candidates, res, new ArrayList<>(), target, 0, 0);
		return res;
	}
	
	public void dfs(int[] candidates, List<List<Integer>> res, List<Integer> list, int target, int index, int sum) {
		if (sum == target) {
			res.add(new ArrayList<>(list));
		}
		if (sum > target) {
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				list.add(candidates[i]);
				dfs(candidates, res, list, target, i, sum + candidates[i]); // not i + 1 because we can reuse same elements
				list.remove(list.size() - 1);
			}
		}
	}
}
