import java.util.Stack;

public class pathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	// Time: O(n), Space: O(n)
	// Using recursion, don't have to change the value of the TreeNode
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null)
			return root.val == sum;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	
	// Time: O(n), Space: O(n)
	// Using iterative stack, need to change the value of the TreeNode
	// if it's not permitted to change the value of the TreeNode,
	// use another stack to store the sum - cur.val value;
	public boolean isPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			if (curr.left == null && curr.right == null) 
				if (curr.val == sum)
					return true;
			if (curr.right != null) {
				curr.right.val += curr.val;
				stack.push(curr.right);
			}
			if (curr.left != null) {
				curr.left.val += curr.val;
				stack.push(curr.left);
			}
		}
		return false;
	}
}
