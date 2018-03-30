import java.util.HashSet;

public class numberOfDistinctIslands {
	
	// Time: O(m * n), Space: O(n);
	public int numDistinctIslands (int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					dfs(grid, i, j, sb, "o"); // origin
					set.add(sb.toString());
				}
			}
		}
		return set.size();
	}
	
	public void dfs (int[][] grid, int i, int j, StringBuilder sb, String direction) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
			return;
		grid[i][j] = 0;
		sb.append(direction);
		dfs(grid, i - 1, j, sb, "u"); // up
		dfs(grid, i + 1, j, sb, "d"); // down
		dfs(grid, i, j - 1, sb, "l"); // left
		dfs(grid, i, j + 1, sb, "r"); // right
		sb.append("b"); // back
	}
}
