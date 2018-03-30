import java.util.LinkedList;
import java.util.Queue;

public class friendCircles {
	
	// dfs version
	// Time: O(n^2), Space: O(n);
	public int findCircleNum (int[][] M) {
		if (M == null || M.length == 0 || M[0].length == 0)
			return 0;
		int res = 0;
		int[] visited = new int[M.length];
		for (int i = 0; i < M.length; i++) {
			if (visited[i] == 0) {
				dfs (M, visited, i);
				res++;
			}
		}
		return res;
	}
	
	public void dfs (int[][] M, int[] visited, int i) {
		for (int j = 0; j < M.length; j++) {
			if (M[i][j] == 1 && visited[j] == 0) {
				visited[j] = 1;
				dfs (M, visited, j);
			}
		}
	}
	
	// bfs version
	// Time: O(n^2), Space: O(n);
	public int findCircleNum2 (int[][] M) {
		if (M == null || M.length == 0 || M[0].length == 0)
			return 0;
		int res = 0;
		int[] visited = new int[M.length];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < M.length; i++) {
			if (visited[i] == 0) {
				queue.offer(i);
				while (!queue.isEmpty()) {
					int cur = queue.poll();
					visited[cur] = 1;
					for (int j = 0; j < M.length; j++) {
						if (M[cur][j] == 1 && visited[j] == 0) {
							queue.offer(j);
						}
					}
				}
				res++;
			}
		}
		return res;
	}
	
	// union find version
	// Time: O(n^2), Space: O(n);
	public int findCircleNum3 (int[][] M) {
		if (M == null || M.length == 0 || M[0].length == 0) {
			return 0;
	    }
	    int m = M.length; // number of rows in this matrix
	    UnionFind unionFind = new UnionFind(m);
	    for (int i = 0; i < m; i++) {
	    		for (int j = i + 1; j < m; j++) {
	    			if (M[i][j] == 1) {
	    				unionFind.union(i, j);
	            }
	        }
	    }
	    return unionFind.count;
	}
	
	class UnionFind {
        int count;
        int[] root;

        public UnionFind(int m) {
            root = new int[m];
            for (int i = 0; i < m; i++) {
                root[i] = i;
            }
            count = m;
        }

        public void union(int i, int j) {
            int x = find(root, i);
            int y = find(root, j);
            if (x != y) {
                count--;
                root[x] = y; // path compression
            }
        }

        public int find(int[] ids, int i) {
            if (ids[i] == i) {
                return i;
            }
            return find(ids, ids[i]);
        }
    }
}
