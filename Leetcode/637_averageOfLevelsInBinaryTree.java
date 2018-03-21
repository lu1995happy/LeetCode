import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class averageOfLevelsInBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	} 
	
	// BFS using queue;
	// Time: O(n), Space: O(n);
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			double sum = 0;
			// size of the level
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				sum += curr.val;
				if (curr.left != null)
					queue.offer(curr.left);
				if (curr.right != null)
					queue.offer(curr.right);
			}
			res.add(sum / size);
		}
		return res;
	}
}
