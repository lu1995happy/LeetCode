
public class convertBSTToGreaterTree {
	
	// Definition for a binary tree node
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	int sum = 0;
	
	// Time: O(n), Space: O(n);
	public TreeNode convertBST (TreeNode root) {
		if (root == null) {
			return root;
		}
		helper(root);
		return root;
	}
	
	public void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		helper(root.right);
		root.val += sum;
		sum = root.val;
		helper(root.left);
	}
}
