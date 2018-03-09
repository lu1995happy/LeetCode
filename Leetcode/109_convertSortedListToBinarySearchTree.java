public class convertSortedListToBinarySearchTree {
	public class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {
			val = x;
		}
	}
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { 
	    		val = x; 
	    	}
	}
	// Time: O(n), Space: O(n);
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		return helper(head, null);
	}
	
	public TreeNode helper(ListNode head, ListNode tail) {
		if (head == tail) 
			return null;
		// use the two pointer method to find the medium node;
		ListNode slow = head, fast = head;
		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode node = new TreeNode(slow.val);
		node.left = helper(head, slow);
		node.right = helper(slow.next, tail);
		return node;
	}
}
