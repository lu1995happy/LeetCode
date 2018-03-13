
public class rotateList {
	
	// Time: O(n), Space: O(1);
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
	}
	
	// Since n may be a large number compared to the length of list. So we need to know the length of linked list.
	// After that, connect the LinkedList as a cycle LinkedList, rotate the whole cycle LinkedList to make the 
	// len - k % len node to the front of the LinkedList.
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		// since we are already at head node
		int length = 1;
		ListNode index = head;
		while (index.next != null) {
			index = index.next;
			length++;
		}
		index.next = head;
		for (int i = 1; i < length - k % length; i++) {
			head = head.next;
		}
		ListNode res = head.next;
		head.next = null;
		return res;
	}
}
