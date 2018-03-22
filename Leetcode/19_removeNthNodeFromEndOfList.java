
public class removeNthNodeFromEndOfList {
	
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {
			val = x;
		}
	}
	
	// Time: O(n), Space: O(1);
	// two pointers
	// Move one pointer fast --> n+1 places forward, to maintain a gap of n between the two pointers and then move both 
	// at the same speed. Finally, when the fast pointer reaches the end, the slow pointer will be n+1 places behind - just 
	// the right spot for it to be able to skip the next node.
	public ListNode removeNthFromEnd (ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		ListNode slow = dummy, fast = dummy;
		dummy.next = head;
		for (int i = 0; i <= n; i++) 
			fast = fast.next;
		
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
}
