
public class addTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {
			val = x;
		}
	}
	
	// Time: O(n), Space: O(n);
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode p1 = l1, p2 = l2, curr = dummy;
		int sum = 0;
		while (p1 != null || p2 != null) {
			if (p1 != null) {
				sum += p1.val;
				p1 = p1.next;
			}
			if (p2 != null) {
				sum += p2.val;
				p2 = p2.next;
			}
			curr.next = new ListNode (sum % 10);
			sum /= 10;
			curr = curr.next;
		}
		if (sum == 1) 
			curr.next = new ListNode(1);
		return dummy.next;
	}
}
