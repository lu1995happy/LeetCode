import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeZigzagLevelOrderTraversal {
	
	// Definition for a binary tree node
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	// DFS
	// Time: O(n), Space: O(n);
	public List<List<Integer>> zigzagLevelOrder (TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		helper(res, root, 0, true);
		return res;
	}
	
	public void helper (List<List<Integer>> res, TreeNode root, int level, boolean even) {
		if (root == null) {
			return;
		}
		while (level >= res.size()) {
			res.add(new ArrayList<>());
		}
		if (even) {
			res.get(level).add(root.val);
		} else {
			res.get(level).add(0, root.val);
		}
		even = even ? false : true;
		helper(res, root.left, level + 1, even);
		helper(res, root.right, level + 1, even);
	}
	
	// BFS 
	// Time: O(n), Space: O(n);
	public List<List<Integer>> zigzagLevelOrder2 (TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean zigzag = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (zigzag) {
					list.add(cur.val);
				} else {
					list.add(0, cur.val);
				}
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			zigzag = zigzag ? false : true;
			res.add(list);
		}
		return res;
	}
}
