
public class longestUnivaluePath {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	int res;
	
    // Time: O(n), Space: O(h)
	public int longestUnivaluePath (TreeNode root) {
		if (root == null)
			return 0;
		res = 0;
		dfs(root);
		return res;
	}
	
	public int dfs(TreeNode root) {
		// Longest-Univalue-Path-Start-At - left child
		int l = root.left != null ? dfs(root.left) : 0; 
		// Longest-Univalue-Path-Start-At - right child
		int r = root.right != null ? dfs(root.right) : 0; 
		// Longest-Univalue-Path-Start-At - node, and go left
		int pl = root.left != null && root.left.val == root.val ? l + 1 : 0; 
		// Longest-Univalue-Path-Start-At - node, and go right
		int pr = root.right != null && root.right.val == root.val ? r + 1 : 0;
		// Longest-Univalue-Path-Across - node
		res = Math.max(res, pl + pr);
		return Math.max(pl, pr);
	}
}
