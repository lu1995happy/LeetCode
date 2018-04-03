
public class rangeAdditionII {
	
	// Time: O(n), Space: O(1);
	public int maxCount (int m, int n, int[][] ops) {
		if (m == 0 || n == 0)
			return 0;
		if (ops == null || ops.length == 0 || ops[0].length == 0)
			return m * n;
		int minRow = m, minCol = n;
		for (int i = 0; i < ops.length; i++) {
			minRow = Math.min(minRow, ops[i][0]);
			minCol = Math.min(minCol, ops[i][1]);
		}
		return minRow * minCol;
	}
}
