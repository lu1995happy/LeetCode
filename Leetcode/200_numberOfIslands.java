import java.util.LinkedList;
import java.util.Queue;

public class numberOfIslands {
	
	private int m;
	private int n;
	
	// dfs version
	// Time: O(m * n); Space: O(m * n);
	public int numIslands (char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		m = grid.length;
		n = grid[0].length;
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					res++;
				}
			}
		}
		return res;
	}
	
	public void dfs (char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}
	
	// bfs version
	// Time: O(m * n), Space: O(m * n);
	public int numIslands2 (char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					bfs(grid, i, j);
					res++;
				}
			}
		}
		return res;
	}
	
	public void bfs (char[][] grid, int x, int y) {
		grid[x][y] = '0';
		int m = grid.length;
		int n = grid[0].length;
		int code = x * n + y; 
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(code);
		while (!queue.isEmpty()) {
			code = queue.poll();
			int i = code / n;
			int j = code % n;
			if (i > 0 && grid[i - 1][j] == '1') {
				queue.offer((i - 1) * n + j);
				grid[i - 1][j] = '0';
			}
			if (i < m - 1 && grid[i + 1][j] == '1') {
				queue.offer((i + 1) * n + j);
				grid[i + 1][j] = '0';
			}
			if (j > 0 && grid[i][j - 1] == '1') {
				queue.offer(i * n + j - 1);
				grid[i][j - 1] = '0';
			}
			if (j < n - 1 && grid[i][j + 1] == '1') {
				queue.offer(i * n + j + 1);
				grid[i][j + 1] = '0';
			}
		}
	}
}
