import java.util.HashSet;
import java.util.Set;

public class linkedListCycle {
	
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	// Two pointer method without using extra space;
	// Time: O(n), Space: O(1);
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
	
	// HashSet method using extra space
	// Time: O(n), Space: O(n);
	public boolean isCycle(ListNode head) {
		if (head == null)
			return false;
		Set<ListNode> set = new HashSet<>();
		while (head != null) {
			if (!set.add(head))
				return true;
			head = head.next;
		}
		return false;
	}
}
