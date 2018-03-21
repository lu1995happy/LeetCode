import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class invertBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	} 
	
	// straightforward - recursive DFS
	// Time: O(n), Space: O(n);
	// bound to the application stack, which means that it’s no so much scalable 
	// (you can find the problem size that will overflow the stack and crash your application)
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
	
	// DFS using stack
	// more stable version
    public TreeNode invertTree3(TreeNode root) {
        
        if (root == null)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }
	
	// BFS using Queue - level order traversal
	// Time: O(n), Space: O(n)
	public TreeNode invertTree2(TreeNode root) {
		if (root == null)
			return root;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {		
			TreeNode curr = queue.poll();
			TreeNode temp = curr.left;
			curr.left = curr.right;
			curr.right = temp;
			if (curr.left != null)
				queue.offer(curr.left);
			if (curr.right != null)
				queue.offer(curr.right);		
		}
		return root;
	}
}
