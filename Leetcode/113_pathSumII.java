import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class pathSumII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	// Time: O(n), Space: O(n);
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		helper(res, new ArrayList<>(), root, sum);
		return res;
	}
	
	// using DFS, back tracking
	public void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
		if (root == null)
			return;
		list.add(root.val);
		if (root.left == null && root.right == null && root.val == sum)
				res.add(new ArrayList<>(list));
		else {
			helper(res, list, root.left, sum - root.val);
			helper(res, list, root.right, sum - root.val);
		}
		// don't forget to remove the last integer
		list.remove(list.size() - 1);
	}
	
	// iterative solution using post-order traversal;
	// using stack to implement DFS
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        // sum along the current path
        int pathSum = 0;
        TreeNode prev = null;
        TreeNode curr = root;
        while (curr != null || !s.isEmpty()){
            // go down all the way to the left leaf node
            // add all the left nodes to the stack 
            while (curr != null){
                s.push(curr);
                // record the current path
                path.add(curr.val);
                // record the current sum along the current path
                pathSum += curr.val;
                curr = curr.left;
            }
            // check left leaf node's right subtree 
            // or check if it is not from the right subtree
            // why peek here? 
            // because if it has right subtree, we don't need to push it back
            curr = s.peek();
            if (curr.right != null && curr.right != prev){
                curr = curr.right;
                continue; // back to the outer while loop
            }
            // check leaf 
            if (curr.left == null && curr.right == null && pathSum == sum){
                list.add(new ArrayList<Integer>(path));
                // why do we need new ArrayList here?
                // if we are using the same path variable path
                // path will be cleared after the traversal
            }
            // pop out the current value
            s.pop();
            prev = curr;
            // subtract current node's value from path sum 
            pathSum -= curr.val;
            // as this current node is done, remove it from the current path
            path.remove(path.size()-1);
            // reset current node to null, so check the next item from the stack 
            curr = null;
        }
        return list;
    }
}
