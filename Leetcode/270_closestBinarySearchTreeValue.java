
public class closestBinarySearchTreeValue {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	// recursion version;
	// Time: O(n), Space: O(h);
	public int closestValue (TreeNode root, double target) {
		int a = root.val;
		TreeNode kid = a > target ? root.left : root.right;
		if (kid == null)
			return a;
		int b = closestValue(kid, target);
		return Math.abs(a - target) > Math.abs(b - target) ? b : a;
	}
	
	// iteration version
	// Time: O(n), Space: O(1);
	public int closestValue2(TreeNode root, double target) {
		int ans = root.val;
		TreeNode child = ans > target ? root.left : root.right;
        while(child != null) {
            int b = child.val;
            ans = Math.abs(ans -target) < Math.abs(b -target) ? ans : b;
            child = b > target ? child.left : child.right;
            if (child == null) 
            		return ans;
        }
		return ans;
    }
}
