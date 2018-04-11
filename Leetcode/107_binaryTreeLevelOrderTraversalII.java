import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeLevelOrderTraversalII {
	
	// Definition for a binary tree node
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	// BFS
	// Time: O(n), Space: O(n);
	public List<List<Integer>> levelOrderBottom (TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				list.add(cur.val);
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			res.add(0, list);
		}
		return res;
	}
	
	// DFS
	// Time: O(n), Space: O(n);
	public List<List<Integer>> levelOrderBottom2 (TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		helper(res, root, 0);
		return res;
	}
	
	public void helper (List<List<Integer>> res, TreeNode root, int level) {
		if (root == null) {
			return;
		}
		while (level >= res.size()) {
			res.add(0, new ArrayList<>());
		}
		res.get(res.size() - level - 1).add(root.val);
		helper(res, root.left, level + 1);
		helper(res, root.right, level + 1);
	}
}
