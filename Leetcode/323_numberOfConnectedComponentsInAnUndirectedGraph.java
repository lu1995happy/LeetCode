import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class numberOfConnectedComponentsInAnUndirectedGraph {
	
	// union-find solution
	// Time: O(edges * nodes), Space: O(n);
	// n points = n islands = n trees = n roots.
	// With each edge added, check which island is e[0] or e[1] belonging to.
	// If e[0] and e[1] are in same islands, do nothing.
	// Otherwise, union two islands, and reduce islands count by 1.
	// Bonus: path compression can reduce time by 50%.
	public int countComponents (int n, int[][] edges) {
		int res = n;
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i;
		}
		for (int i = 0; i < edges.length; i++) {
			int x = find(nums, edges[i][0]);
			int y = find(nums, edges[i][1]);
			if (x != y) { // union
				nums[x] = y;
				res--;
			}
		}
		return res;
	}
	
	public int find (int[] nums, int i) {
		while (nums[i] != i) {
			nums[i] = nums[nums[i]]; // optional: path compression
			i = nums[i];
		}
		return i;
	}
	
	// dfs solution
	// Time: O(edges * nodes), Space: O(n);
	public int countComponents2 (int n, int[][] edges) {
		if (n <= 1)
			return n;
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
		int count = 0;
		for (int i = 0; i < n; i++) {
			// if the edge is not connected, increase the count;
			if (visited.add(i)) {
				dfs(graph, visited, i);
				count++;
			}
		}
		return count;
	}
	
	public void dfs(List<List<Integer>> graph, HashSet<Integer> visited, int node) {
		List<Integer> sub = graph.get(node);
		// find all the nodes connected together;
		for (int num : sub) {
			if (visited.add(num)) {
				dfs(graph, visited, num);
			}
		}
	}
}
