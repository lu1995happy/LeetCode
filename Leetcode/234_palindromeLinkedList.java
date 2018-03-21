
public class palindromeLinkedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	// Time: O(n), Space: O(1);
	// check if the first half and second half are same
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode middle = findMiddle(head);
		middle = reverse(middle);
		ListNode p = head;
		ListNode q = middle;
		while (p != null && q != null) {
			if (p.val != q.val) 
				return false;
			p = p.next;
			q = q.next;
		}
		return true;
	}
	
	// find the middle edge for the LinkedList
	public ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	// reverse the right half of the LinkedList
	public ListNode reverse(ListNode head) {
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
