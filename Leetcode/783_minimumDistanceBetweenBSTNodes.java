
public class minimumDistanceBetweenBSTNodes {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	int res = Integer.MAX_VALUE;
	Integer prev = null;
	
	// same as Leetcode 530
	// Time: O(n), Space: O(n);
	public int minDiffInBST (TreeNode root) {
		if (root == null)
			return res;
		minDiffInBST(root.left);
		if (prev != null) {
			res = Math.min(res, Math.abs(root.val - prev));
		}
		prev = root.val;
		minDiffInBST(root.right);
		return res;
	}
}
