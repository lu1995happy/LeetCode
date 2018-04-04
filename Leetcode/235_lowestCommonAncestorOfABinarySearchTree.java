
public class lowestCommonAncestorOfABinarySearchTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	// Time: O(n), Space: O(n);
	// recursion
	public TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (root.val < p.val && root.val < q.val){
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}
	
	// iteration
	// Time: O(n), Space: O(1);
	public TreeNode lowestCommonAncestor2 (TreeNode root, TreeNode p, TreeNode q) {
		while ((root.val - p.val) * (root.val - q.val) > 0) {
			if (p.val < root.val) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return root;
	}
}
