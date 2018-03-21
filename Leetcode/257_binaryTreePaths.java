import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class binaryTreePaths {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	} 
	// DFS method 
	// Time: O(n) in average case, O(nlogn) in worst case for balanced binary tree;
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null)
			return res;
		StringBuilder sb = new StringBuilder();
		helper(res, root, sb);
		return res;
	}
	
	public void helper(List<String> res, TreeNode root, StringBuilder sb) {
		if (root == null)
			return;
		int len = sb.length();
		sb.append(root.val);
		if (root.left == null && root.right == null) 
			res.add(sb.toString());
		else {
			sb.append("->");
			if (root.left != null)
				helper(res, root.left, sb);
			if (root.right != null)
				helper(res, root.right, sb);
		}
		sb.setLength(len);
	}
	
	//BFS - Queue
	public List<String> binaryTreePaths2(TreeNode root) {
	    List<String> list=new ArrayList<String>();
	    Queue<TreeNode> qNode=new LinkedList<TreeNode>();
	    Queue<String> qStr=new LinkedList<String>();
	    
	    if (root==null) return list;
	    qNode.add(root);
	    qStr.add("");
	    while(!qNode.isEmpty()) {
	        TreeNode curNode=qNode.remove();
	        String curStr=qStr.remove();
	        
	        if (curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
	        if (curNode.left!=null) {
	            qNode.add(curNode.left);
	            qStr.add(curStr+curNode.val+"->");
	        }
	        if (curNode.right!=null) {
	            qNode.add(curNode.right);
	            qStr.add(curStr+curNode.val+"->");
	        }
	    }
	    return list;
	}
	
	//DFS - Stack
	public List<String> binaryTreePaths3(TreeNode root) {
	    List<String> list=new ArrayList<String>();
	    Stack<TreeNode> sNode=new Stack<TreeNode>();
	    Stack<String> sStr=new Stack<String>();
	    
	    if(root==null) return list;
	    sNode.push(root);
	    sStr.push("");
	    while(!sNode.isEmpty()) {
	        TreeNode curNode=sNode.pop();
	        String curStr=sStr.pop();
	        
	        if(curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
	        if(curNode.left!=null) {
	            sNode.push(curNode.left);
	            sStr.push(curStr+curNode.val+"->");
	        }
	        if(curNode.right!=null) {
	            sNode.push(curNode.right);
	            sStr.push(curStr+curNode.val+"->");
	        }
	    }
	    return list;
	}
}
