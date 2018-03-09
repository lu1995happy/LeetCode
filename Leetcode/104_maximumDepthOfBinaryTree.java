
public class maximumDepthOfBinaryTree {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { 
	    	  	val = x; 
	    	  }
	}
	
	// Time: O(n), Space: O(n);
	public int maxDepth (TreeNode root) {
		
		// return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		
		if (root == null)
			return 0;
		int left = maxDepth(root.left) + 1;
		int right = maxDepth(root.right) + 1;
		return Math.max(left, right);
	}
}
