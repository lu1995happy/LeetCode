import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeLevelOrderTraversal {
	
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
	public List<List<Integer>> levelOrder (TreeNode root) {
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
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
				list.add(cur.val);
 			}
			res.add(new ArrayList<>(list));
		}
		return res;
	}
	
	// DFS
	// Time: O(n), Space: O(n);
	public List<List<Integer>> levelOrder2 (TreeNode root) {
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
			res.add(new ArrayList<>());
		}
		res.get(level).add(root.val);
		helper(res, root.left, level + 1);
		helper(res, root.right, level + 1);
	}
}
