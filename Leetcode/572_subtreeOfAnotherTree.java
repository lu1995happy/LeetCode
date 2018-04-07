
public class subtreeOfAnotherTree {
	// Definition for a binary tree node
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	// Time: O(m * n), Space: O(n);
	// For each node during pre-order traversal of s, use a recursive function isSame to validate 
	// if sub-tree started with this node is the same with t
	public boolean isSubtree (TreeNode s, TreeNode t) {
		if (s == null) {
			return false;
		}
		if (isSameTree(s, t)) {
			return true;
		}
		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}
	
	public boolean isSameTree (TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null || s.val != t.val) {
			return false;
		}
		return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	}
}
