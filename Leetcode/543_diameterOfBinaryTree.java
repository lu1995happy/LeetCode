
public class diameterOfBinaryTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	int res = 0;
	
	// Time: O(n), Space: O(h);
	// very similar as Leetcode: 687 Longest Univalue Path; 
    // length of longest path = MaxDepth of its left subtree + MaxDepth of its right subtree.
	public int diameterOfBinaryTree (TreeNode root) {
		dfs(root);
		return res;
	}
	
	public int dfs(TreeNode root) {
        if (root == null)
            return 0;
		int left = dfs(root.left);
        int right = dfs(root.right);
		res = Math.max(res, left + right);
		return Math.max(left, right) + 1;
	}
}
