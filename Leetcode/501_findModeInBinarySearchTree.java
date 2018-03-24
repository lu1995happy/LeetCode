
public class findModeInBinarySearchTree {
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { 
	    	  	val = x; 
	    	  }
	}
	
	private int currValue;
	private int currCount = 0;
	private int maxCount = 0;
	private int modeCount = 0;
	private int[] modes;
	
	// Time: O(n), Space: O(1);
	// two passes. One to find the highest number of occurrences of any value, and then 
	// a second pass to collect all values occurring that often.
	public int[] findMode (TreeNode root) {
		inorder(root);
		modes = new int[modeCount];
		modeCount = 0;
		currCount = 0;
		inorder(root);
		return modes;
	}
	
	public void handleValue (int val) {
		if (val != currValue) {
			currValue = val;
			currCount = 0;
		}
		currCount++;
		if (currCount > maxCount) {
			maxCount = currCount;
			modeCount = 1;
		} else if (currCount == maxCount) {
			if (modes != null) 
				modes[modeCount] = currValue;
			modeCount++;
		}
	}
	
	public void inorder (TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		handleValue(root.val);
		inorder(root.right);
	}
	
	// Morris traversal
	private void inorder2(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                handleValue(node.val);
                node = node.right;
            } else {
                TreeNode prev = node.left;
                while (prev.right != null && prev.right != node)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    prev.right = null;
                    handleValue(node.val);
                    node = node.right;
                }
            }
        }
    }
}
