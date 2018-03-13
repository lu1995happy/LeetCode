import java.util.TreeSet;
import java.util.HashMap;

public class containsDuplicateIII {
	
	// Bucket method
	// Time: O(n), Space: O(k);
	// As a follow-up question, it naturally also requires maintaining a window of size k. When t == 0, 
	// it reduces to the previous question so we just reuse the solution.
	// Since there is now a constraint on the range of the values of the elements to be considered duplicates, it 
	// reminds us of doing a range check which is implemented in tree data structure and would take O(LogN) if a balanced
	// tree structure is used, or doing a bucket check which is constant time. We shall just discuss the idea using bucket 
	// here. Bucketing means we map a range of values to the a bucket. For example, if the bucket size is 3, we consider
	// 0, 1, 2 all map to the same bucket. However, if t == 3, (0, 3) is a considered duplicates but does not map to the 
	// same bucket. This is fine since we are checking the buckets immediately before and after as well. So, as a rule of 
	// thumb, just make sure the size of the bucket is reasonable such that elements having the same bucket is immediately 
	// considered duplicates or duplicates must lie within adjacent buckets. So this actually gives us a range of possible
	// bucket size, i.e. t and t + 1. We just choose it to be t and a bucket mapping to be num / t.
	// Another complication is that negative ints are allowed. A simple num / t just shrinks everything towards 0. 
	// Therefore, we can just reposition every element to start from Integer.MIN_VALUE.
	// Actually, we can use t + 1 as the bucket size to get rid of the case when t == 0. It simplifies the code.
	public boolean containsDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0 || t < 0) 
            return false;
		HashMap<Long, Long> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
			long bucket = remappedNum / ((long) t + 1);
			if (map.containsKey(bucket) || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t) 
					|| map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t) 
				return true;
			if (map.entrySet().size() >= k) {
				long lastBucket = ((long) nums[i - k] -Integer.MIN_VALUE) / ((long)t + 1);
				map.remove(lastBucket);
			}
			map.put(bucket, remappedNum);
		}
		return false;
	}
	
	// TreeSet method
	// Time: O(nlogk), Space: O(k);
	// This problem requires to maintain a window of size k of the previous values that can be queried for value ranges.
	// The best data structure to do that is Binary Search Tree. As a result maintaining the tree of size k will result in
	// time complexity O(N lg K). In order to check if there exists any value of range abs(nums[i] - nums[j]) to simple 
	// queries can be executed both of time complexity O(lg K)
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0 || t < 0) 
            return false;
     
		TreeSet<Long> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			Long floor = set.floor((long)nums[i] + t);
			Long ceil = set.ceiling((long)nums[i] - t);
			if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i]))
				return true;
			set.add((long)nums[i]);
			if (i >= k) 
				set.remove((long)nums[i - k]);
		}
		return false;
	}
}
