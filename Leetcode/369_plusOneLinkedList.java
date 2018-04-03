
public class plusOneLinkedList {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	
	// Time: O(n), Space: O(1);
	public ListNode plusOne (ListNode head) {
		if (head == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode i = dummy;
		ListNode j = dummy;
		// for the case : 1 -> 2 -> 3
		while (j.next != null) {
			j = j.next;
			if (j.val != 9) {
				i = j;
			}
		}
		i.val++;
		// for the case : 1 -> 2 -> 9
		while (i.next != null) {
			i = i.next;
			i.val = 0;
		}
		// for the case : 9 -> 9 -> 9
		if (dummy.val == 1) {
			return dummy;
		} else {
			return dummy.next;
		}
	}
	
	public ListNode plusOne2 (ListNode head) {
		if (head == null)
			return head;
		head = reverse(head);
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		int carry = 1;
		while (cur.next != null || carry > 0) {
			if (cur.next != null) {
				cur = cur.next;
				carry += cur.val;
				cur.val = carry % 10;
				carry /= 10;
			} else {
				cur.next = new ListNode(carry);
				cur = cur.next;
				carry = 0;
			}	
		}
		return reverse(dummy.next);
	}
	
	public ListNode reverse (ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
}
