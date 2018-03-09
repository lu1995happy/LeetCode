public class minimumDepthOfBinaryTree {
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { 
	    		val = x; 
	    	}
	}
	
	// Time: O(n), Space: O(n);
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null || root.right == null)
			return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
}
