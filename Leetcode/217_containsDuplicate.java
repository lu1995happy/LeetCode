import java.util.HashSet;

public class containsDuplicate {
	// 3 ways to solve this problem:
	// 1: HashSet (Time: O(n), Space: O(n));
	// 2: sort and then check (Time: O(nlogn), Space: O(1));
	// 3: brute force (Time: O(n^2), Space: O(1));
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}
}
