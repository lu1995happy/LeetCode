import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binaryTreeInorderTraversal {
	
	// Definition for a binary tree node
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	// iteration method
	// Time: O(n), Space: O(h), worst case : O(n);
	public List<Integer> inorderTraversal (TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				res.add(root.val);
				root = root.right;
			}
		}
		return res;
	}
	
	// recursion method
	// Time: O(n), Space: O(n);
	public List<Integer> inorderTraversal2 (TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		helper(res, root);
		return res;
	}
	
	public void helper(List<Integer> res, TreeNode root) {
		if (root == null) {
			return;
		}
		helper(res, root.left);
		res.add(root.val);
		helper(res, root.right);
	}
}
