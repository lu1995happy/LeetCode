import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class graphValidTree {
	
	// union-find version
	// Time: O(edges * nodes), Space: O(n);
	public boolean validTree (int n, int[][] edges) {
		if (n == 1 && edges.length == 0)
			return true;
		if (n < 1 || edges == null || edges.length != n - 1)
			return false;
		// initialize n isolated islands
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i;
		}
		// perform union find
		for (int i = 0; i < edges.length; i++) {
			int x = find(nums, edges[i][0]);
			int y = find(nums, edges[i][1]);
			// if two vertices happen to be in the same set
            // then there's a cycle
			if (x == y) 
				return false;
			// union
			nums[x] = y;
		}
		return true;
	}
	
	public int find (int[] nums, int i) {
		while (nums[i] != i) {
			nums[i] = nums[nums[i]]; // optional: path compression
			i = nums[i];
		}
		return i;
	}
	
	// dfs version
	// Time: O(edges * nodes), Space: O(n);
	public boolean validTree2 (int n, int[][] edges) {
		 // initialize graph list
		List<List<Integer>> graph = new ArrayList<>();
		// initialize vertices
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		// add edges    
		for (int i = 0; i < edges.length; i++) {
			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
		}
		HashSet<Integer> visited = new HashSet<>();
		visited.add(0);
		// do DFS from vertex 0, after one round DFS, if there is no loop and visited contains all the vertexs,
        // it is a tree.
		boolean res = dfs(graph, visited, 0, -1);
		// make sure there's no cycle
		if (res == false)
			return false;
		// make sure all vertices are connected
		return visited.size() == n ? true : false;
	}
	
	// check if an undirected graph has cycle started from vertex u
	public boolean dfs(List<List<Integer>> graph, HashSet<Integer> visited, int node, int parent) {
		List<Integer> sub = graph.get(node);
		for (int num : sub) {
			// if v is vertex's parent, continue.
			if (num == parent)
				continue;
			 // if v is not vertex's parent, and v is visited. that presents there is a cycle in this graph.
			if (visited.contains(num))
				return false;
			visited.add(num);
			boolean res = dfs(graph, visited, num, node);
			if (res == false)
				return false;
		}
		return true;
	}
}
