import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class findKPairsWithSmallestSums {
	
	class Tuple {
		int x, y, val;
		public Tuple(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
	
	// Time: O(nlogk), Space: O(k);
	// similar idea used in Leetcode 378. Kth Smallest Element in a Sorted Matrix
	public List<int[]> kSmallestPairs (int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<>();
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) {
			return res;
		}
		PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
		for (int i = 0; i < nums2.length && k > i; i++) {
			pq.offer(new Tuple(0, i, nums1[0] + nums2[i]));
		}
		for (int i = 0; i < Math.min(k, nums1.length * nums2.length); i++) {
			Tuple tuple = pq.poll();
			res.add(new int[] {nums1[tuple.x], nums2[tuple.y]});
			if (tuple.x == nums1.length - 1) {
				continue;
			}
			pq.offer(new Tuple(tuple.x + 1, tuple.y, nums1[tuple.x + 1] + nums2[tuple.y]));
		}
		return res;
	}
}
