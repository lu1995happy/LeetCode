import java.util.Stack;

public class binarySearchTreeIterator {
	
	// Definition for a binary tree node
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	TreeNode cur;
	Stack<TreeNode> stack;
	
	// Time: O(n), Space: O(n);
	// same as Leetcode 94: Binary Tree Inorder Traversal;
    public binarySearchTreeIterator (TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (cur != null) {
        		stack.push(cur);
        		cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
