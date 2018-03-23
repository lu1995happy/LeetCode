import java.util.HashMap;

public class numberOfBoomerangs {
	
	// Time: O(n^2), Space: O(n);
	public int numberOfBoomerangs (int[][] points) {
		if (points == null || points.length == 0)
			return 0;
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (i == j)
					continue;
				int distance = getDistance(points[i], points[j]);
				map.put(distance, map.getOrDefault(distance, 0) + 1);
			}
			// For every i, we capture the number of points equal distance from i. Now for this i, we have to calculate all 
			// possible permutations of (j,k) from these equal distance points.
			// Total number of permutations of size 2 from n different points is nP2 = n!/(n-2)! = n * (n - 1).
			for (int x : map.values()) 
				res += x * (x - 1);
			map.clear();
		}
		return res;
	}
	
	public int getDistance(int[] a, int[] b) {
		int dx = a[0] - b[0];
		int dy = a[1] - b[1];
		return dx * dx + dy * dy;
	}
}
