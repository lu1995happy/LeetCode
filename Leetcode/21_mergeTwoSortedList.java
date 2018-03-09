public class mergeTwoSortedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {
			val = x;
		}
	}
	// Time: O(n), Space: O(n);
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode p1 = l1, p2 = l2, curr = dummy;
		while (p1 != null || p2 != null) {
			if (p1 == null) {
				curr.next = new ListNode(p2.val);
				p2 = p2.next;
			} else if (p2 == null) {
				curr.next = new ListNode(p1.val);
				p1 = p1.next;
			} else {
				if (p1.val > p2.val) {
					curr.next = new ListNode(p2.val);
					p2 = p2.next;
				} else {
					curr.next = new ListNode(p1.val);
					p1 = p1.next;
				}
			}
			curr = curr.next;
		}
		return dummy.next;
	}
	
	// shorter code
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				curr.next = new ListNode (l2.val);
				l2 = l2.next;
			} else {
				curr.next = new ListNode (l1.val);
				l1 = l1.next;
			}
			curr = curr.next;
		}
		if (l1 != null) {
			curr.next = l1;
		} else {
			curr.next = l2;
		}
		return dummy.next;
	}
	
	// recursion way
	public ListNode mergeRecursion(ListNode l1, ListNode l2) {
		if (l1 == null) 
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val > l2.val) {
			l2.next = mergeRecursion(l1, l2.next);
			return l2;
		}
		else {
			l1.next = mergeRecursion(l1.next, l2);
			return l1;
		}
	}
}
