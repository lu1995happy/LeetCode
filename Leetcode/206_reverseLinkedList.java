
public class reverseLinkedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	
	// iterative version
	// Time: O(n), Space: O(1) --- In-place
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) 
			return head;
		ListNode pre = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = pre;
			pre = head;
			head = tmp;
		}
		return pre;
	}
	
	// recursion version
	// Time: O(n), Space: O(1) --- In-place
	public ListNode reverseRecursion(ListNode head) {
		return reverse(head, null);
	}
	
	public ListNode reverse(ListNode head, ListNode newHead) {
		if (head == null) 
			return newHead;
		ListNode next = head.next;
		head.next = newHead;
		return reverse(next, head);
	}
}
