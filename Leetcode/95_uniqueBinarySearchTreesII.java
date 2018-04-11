import java.util.ArrayList;
import java.util.List;

public class uniqueBinarySearchTreesII {
	
	// Definition for a binary tree node
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	// Time: O(n^(n - 1)) ? 
	// DFS
	// I start by noting that 1…n is the in-order traversal for any BST with nodes 1 to n. So if I pick i-th node as my 
	// root, the left subtree will contain elements 1 to (i-1), and the right subtree will contain elements (i+1) to n. 
	// I use recursive calls to get back all possible trees for left and right subtrees and combine them in all possible 
	// ways with the root.
	public List<TreeNode> generateTrees (int n) {
		if (n == 0) {
			return new ArrayList<>();
		}
		return generateTreeLists(1, n);
	}
	
	public List<TreeNode> generateTreeLists (int start, int end) {
		List<TreeNode> list = new ArrayList<>();
		if (start > end) {
			list.add(null);
		}
		for (int index = start; start <= end; index++) {
			List<TreeNode> leftList = generateTreeLists(start, index - 1);
			List<TreeNode> rightList = generateTreeLists(index + 1, end);
			for (TreeNode left : leftList) {
				for (TreeNode right : rightList) {
					TreeNode root = new TreeNode(index);
					root.left = left;
					root.right = right;
					list.add(root);
				}
			}
		}
		return list;
	}
	
	// DP version
	public List<TreeNode> generateTrees2(int n) {
	    List<TreeNode>[] result = new List[n + 1];
	    result[0] = new ArrayList<TreeNode>();
	    if (n == 0) {
	        return result[0];
	    }
	    result[0].add(null);
	    for (int len = 1; len <= n; len++) {
	        result[len] = new ArrayList<TreeNode>();
	        for (int j = 0; j < len; j++) {
	            for (TreeNode nodeL : result[j]) {
	                for (TreeNode nodeR : result[len - j - 1]) {
	                    TreeNode node = new TreeNode(j + 1);
	                    node.left = nodeL;
	                    node.right = clone(nodeR, j + 1);
	                    result[len].add(node);
	                }
	            }
	        }
	    }
	    return result[n];
	}

	private TreeNode clone(TreeNode n, int offset) {
	    if (n == null) {
	        return null;
	    }
	    TreeNode node = new TreeNode(n.val + offset);
	    node.left = clone(n.left, offset);
	    node.right = clone(n.right, offset);
	    return node;
	}
}
