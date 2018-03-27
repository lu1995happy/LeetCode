
public class binaryTreeLongestConsecutiveSequence {
	
	// Definition for a binary tree node
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	} 
	
	public int res = 0;
	
	// Time: O(n), Space: O(n);
	// DFS
	public int longestConsecutive(TreeNode root) {
		if (root == null)
			return 0;
		helper(root, 0, root.val);
		return res;
	}
	
	public void helper(TreeNode root, int len, int target) {
		if (root == null)
			return;
		if (root.val == target) 
			len++;
		else 
			len = 1;
		res = Math.max(res, len);
		helper(root.left, len, root.val + 1);
		helper(root.right, len, root.val + 1);
	}
}
