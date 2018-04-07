import java.util.ArrayList;
import java.util.List;

public class combinationSumIII {
	
	// backtracking
	// Time: O(2^n), Space: O(2^n);
	public List<List<Integer>> combinationSum3 (int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(res, new ArrayList<>(), k, n, 0, 1);
		return res;
	}
	
	public void dfs (List<List<Integer>> res, List<Integer> list, int k, int target, int sum, int index) {
		if (k == 0) {
			if (sum == target) {
				res.add(new ArrayList<>(list));
			} else {
				return;
			}
		}
		if (sum > target || list.size() > k) {
			return;
		}
		for (int i = index; i <= 9; i++) {
			if (i <= target) {
				list.add(i);
				dfs(res, list, k - 1, target, sum + i, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}
}
