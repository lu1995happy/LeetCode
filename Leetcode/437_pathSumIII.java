import java.util.HashMap;

public class pathSumIII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	 // Using DFS + HashMap memorization 
	 // Time: O(n), Space: O(n)
	 // So the idea is similar as Two sum, using HashMap to store ( key : the prefix sum, value : how many ways get 
	 // to this prefix sum) , and whenever reach a node, we check if prefix sum - target exists in hashmap or not, if it 
	 // does, we added up the ways of prefix sum - target into res. For instance : in one path we have 1,2,-1,-1,2, then 
	 // the prefix sum will be: 1, 3, 2, 1, 3, let’s say we want to find target sum is 2, then we will have{2}, {1,2,-1}, 
	 // {2,-1,-1,2} and {2}ways. I used global variable count, but obviously we can avoid global variable by passing the 
	 // count from bottom up. The time complexity is O(n). 
	
	 // Hope my comment here could help understanding this solution.
	 // 1. The prefix stores the sum from the root to the current node in the recursion
	 // 2. The map stores <prefix sum, frequency> pairs before getting to the current node. We can imagine a path from the 
	 // root to the current node. The sum from any node in the middle of the path to the current node = the difference 
	 // between the sum from the root to the current node and the prefix sum of the node in the middle.
	 // 3. We are looking for some consecutive nodes that sum up to the given target value, which means the difference 
	 // discussed in 2. should equal to the target value. In addition, we need to know how many differences are equal to the 
	 // target value.
	 // 4. Here comes the map. The map stores the frequency of all possible sum in the path to the current node. If the 
	 // difference between the current sum and the target value exists in the map, there must exist a node in the middle 
	 // of the path, such that from this node to the current node, the sum is equal to the target value.
	 // 5. Note that there might be multiple nodes in the middle that satisfy what is discussed in 4. The frequency in 
	 // the map is used to help with this.
	 // 6. Therefore, in each recursion, the map stores all information we need to calculate the number of ranges that sum 
	 // up to target. Note that each range starts from a middle node, ended by the current node.
	 // 7. To get the total number of path count, we add up the number of valid paths ended by EACH node in the tree.
	 // 8. Each recursion returns the total count of valid paths in the subtree rooted at the current node. And this sum 
	 // can be divided into three parts:
	 // - the total number of valid paths in the subtree rooted at the current node’s left child
	 // - the total number of valid paths in the subtree rooted at the current node’s right child
	 // - the number of valid paths ended by the current node
	 // The interesting part of this solution is that the prefix is counted from the top(root) to the bottom(leaves), 
	 // and the result of total count is calculated from the bottom to the top.
	 public int pathSum2(TreeNode root, int sum) {
		 if (root == null) {
	        return 0;
	     }
		 HashMap<Integer, Integer> preSum = new HashMap<>();
	     preSum.put(0,1);
	     return helper(root, 0, sum, preSum);
	 }
	    
	 public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
	     if (root == null) {
	    	 	return 0;
	     }
	     // update the prefix sum by adding the current value
	     currSum += root.val;
	     // get the number of valid path, ended by the current node
	     int res = preSum.getOrDefault(currSum - target, 0);
	     // update the map with the current sum, so the map is good to be passed to the next recursion
	     preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
	     // add the 3 parts discussed in 8. together
	     res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
	     // restore the map, as the recursion goes from the bottom to the top
	     preSum.put(currSum, preSum.get(currSum) - 1);
	     return res;
	 }
	
	// Time: O(n) + O(n) * height, the best case is O(nlogn) if the tree is a balanced tree, 
	// worst case: O(n^2) for no branching tree;
	// Space: O(n) due to recursion;
	public int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}
	
	// Using DFS
	public int helper(TreeNode root, int sum) {
		int res = 0;
		if (root == null)
			return res;
		if (root.val == sum)
			res++;
		res += helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
		return res;
	}
}
