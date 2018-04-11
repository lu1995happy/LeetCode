import java.util.HashMap;

public class constructBinaryTreeFromPreorderAndInorderTraversal {
	
	// Definition for a binary tree node
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	// Time: O(n), Space: O(n);
	public TreeNode buildTree (int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length) {
			return null;
		}
		HashMap<Integer, Integer> inPosition = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inPosition.put(inorder[i], i);
		}
		return helper (0, 0, inorder.length - 1, inPosition, preorder, inorder);
	}
	
	public TreeNode helper (int preStart, int inStart, int inEnd, HashMap<Integer, Integer> inPosition, 
			int[] preorder, int[] inorder) {
		if (preStart >= preorder.length || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = inPosition.get(root.val);
		root.left = helper (preStart + 1, inStart, inIndex - 1, inPosition, preorder, inorder);
		root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, inPosition, preorder, inorder);
		return root;
	}
}
