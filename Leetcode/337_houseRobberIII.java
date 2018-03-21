import java.util.HashMap;

public class houseRobberIII {
	 // Definition for a binary tree node.
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	 // Dynamic Programming using backtracking
	 // Time: O(n), Space: O(n);
	 public int rob(TreeNode root) {
		 int[] res = helper(root);
		 return Math.max(res[0], res[1]);
	 }
	 
	 public int[] helper(TreeNode root) {
		 // [0] is the max value if not rob the current one
		 // [1] is the max value if rob the current one
		 if (root == null) 
			 return new int[2];
		 int[] res = new int[2];
		 int[] left = helper(root.left);
		 int[] right = helper(root.right);
		 res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		 res[1] = left[0] + right[0] + root.val;
		 return res;
	 }
	 
	 // Dynamic Programming using HashMap
	 public int rob2(TreeNode root) {
		 return robHelper(root, new HashMap<>());
	 }
	 
	 public int robHelper(TreeNode root, HashMap<TreeNode, Integer> map) {
		 if (root == null)
			 return 0;
		 if (map.containsKey(root))
			 return map.get(root);
		 
		 int val = 0;
		 
		 if (root.left != null) 
			 val += robHelper(root.left.left, map) + robHelper(root.left.right, map);
		 
		 if (root.right != null)
			 val += robHelper(root.right.left, map) + robHelper(root.right.right, map);
		 
		 val = Math.max(val + root.val, robHelper(root.left, map) + robHelper(root.right, map));
		 map.put(root, val);
		 
		 return val;
	 }
}
