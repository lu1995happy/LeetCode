import java.util.LinkedList;
import java.util.Queue;

public class sumOfLeftLeaves {
	
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
	// For given node we check whether its left child is a leaf. If it is the case, we add its value to answer, otherwise 
	// recursively call method on left child. For right child we call method only if it has at least one non-null child.
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		int res = 0;
		if (root.left != null) {
			if (root.left.left == null && root.left.right == null)
				res += root.left.val;
			else 
				res += sumOfLeftLeaves(root.left);
		}
		res += sumOfLeftLeaves(root.right);
		return res;
	}
	
	// BFS
	// for each node in the tree we check whether its left child is a leaf. If it is true, we add its value to 
	// answer, otherwise add left child to the stack to process it later. For right child we add it to stack only 
	// if it is not a leaf.
	public int sumOfLeftLeaves2(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		int res = 0;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if (curr.left != null) {
				if (curr.left.left == null && curr.left.right == null)
					res += curr.left.val;
				else 
					queue.offer(curr.left);
			}
			if (curr.right != null)
				queue.offer(curr.right);
		}
		return res;
	}
}
