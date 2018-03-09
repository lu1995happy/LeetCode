public class convertSortedArrayToBinarySearchTree {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { 
	    	  	val = x; 
	    	  }
	}
	
	// Time: O(n); Space: O(n);
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) 
			return null;
		return helper(nums, 0, nums.length - 1);
	}
	
	// IMPORTANCE: for helper function: space: O(logn);
	public TreeNode helper(int[] nums, int left, int right) {
		if (left > right)
			return null;
		int mid = left + (right - left) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, left, mid - 1);
		node.right = helper(nums, mid + 1, right);
		return node;
	}
}
