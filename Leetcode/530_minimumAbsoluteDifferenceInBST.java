import java.util.Stack;
import java.util.TreeSet;

public class minimumAbsoluteDifferenceInBST {
	
	public class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { 
	    		val = x; 
	    	}
	}
	
	int min = Integer.MAX_VALUE;
	Integer prev = null;
	
	// Time: O(n), Space: O(1);
	// first inOrder traverse the tree and compare the delta between each of the adjacent values. 
	// It’s guaranteed to have the correct answer because it is a BST thus inOrder traversal values are sorted.
	public int getMinimumDifference (TreeNode root) {
		if (root == null)
			return min;
		getMinimumDifference(root.left);
		if (prev != null)
			min = Math.min(min, root.val - prev);
		prev = root.val;
		getMinimumDifference(root.right);
		return min;
	}
	
	// iterative version of in-order traverse
	public int getMinimumDifference3(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>(); 
        TreeNode cur = root, pre = null; 
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop(); 
                if (pre != null) 
                    min = Math.min(min, cur.val - pre.val); 
                pre = cur; 
                cur = cur.right; 
            }
        }
        return min; 
    }
	
    TreeSet<Integer> set = new TreeSet<>();
    
	// if not BST? 
	// The idea is to put values in a TreeSet and then every time we can use O(lgN) time to lookup for the nearest values.
	// Pre-Order traverse, time complexity O(NlgN), space complexity O(N).
    // Also we can just put all the values in the array and sort it. 
	 public int getMinimumDifference2(TreeNode root) {
		 if (root == null) 
			 return min;
	        
		 if (!set.isEmpty()) {
			 
			 if (set.floor(root.val) != null) 
				min = Math.min(min, root.val - set.floor(root.val));
			 
	         if (set.ceiling(root.val) != null) 
	        	 	min = Math.min(min, set.ceiling(root.val) - root.val);
	     }
	        
	     set.add(root.val);
	        
	     getMinimumDifference(root.left);
	     getMinimumDifference(root.right);
	        
	     return min;
	 }
}
