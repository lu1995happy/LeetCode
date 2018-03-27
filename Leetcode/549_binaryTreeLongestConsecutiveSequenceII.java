
public class binaryTreeLongestConsecutiveSequenceII {
	
	// Definition for a binary tree node
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	} 
	
	public int max = 0;
	
	// Time: O(n), Space: O(n);
	public int longestConsecutive (TreeNode root) {
		if (root == null)
			return 0;
		longestPath(root);
		return max;
	}
	
	public int[] longestPath (TreeNode root) {
		if (root == null)
			return new int[2];
		int[] left = longestPath(root.left);
		int[] right = longestPath(root.right);
		int inc = 1, dec = 1;
		if (root.left != null) {
			if (root.val - root.left.val == 1) 
				dec = left[1] + 1;
			else if (root.val - root.left.val == -1)
				inc = left[0] + 1;
		}
		if (root.right != null) {
			if (root.val - root.right.val == 1)
				dec = Math.max(dec, right[1] + 1);
			else if (root.val - root.right.val == -1)
				inc = Math.max(inc, right[0] + 1);
		}
		max = Math.max(max, inc + dec - 1);
		return new int[] {inc, dec};
	}
}
