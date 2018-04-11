import java.util.HashMap;

public class constructBinaryTreeFromInorderAndPostorderTraversal {
	
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
	// The the basic idea is to take the last element in postorder array as the root, find the position of the root in 
	// the inorder array; then locate the range for left sub-tree and right sub-tree and do recursion. Use a HashMap 
	// to record the index of root in the inorder array.
	public TreeNode buildTree (int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length) {
			return null;
		}
		HashMap<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}
		return helper (0, postorder.length - 1, 0, inorder.length - 1, inMap, inorder, postorder);
	}
	
	public TreeNode helper (int postStart, int postEnd, int inStart, int inEnd, HashMap<Integer, Integer> inMap, 
			int[] inorder, int[] postorder) {
		if (postStart < 0 || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode (postorder[postEnd]);
		int inIndex = inMap.get(root.val);
		root.left = helper(postStart, postStart + inIndex - inStart - 1, inStart, inIndex - 1, inMap, inorder, postorder);
		root.right = helper(postStart + inIndex - inStart, postEnd - 1, inIndex + 1, inEnd, inMap, inorder, postorder);
		return root;
	}
}
