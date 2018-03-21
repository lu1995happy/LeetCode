
public class linkedListCycleII {
	
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	// Two pointer method, no extra space; 
	// use slow and fast find the first meet position. Then using the idea that 2(a+b) = a + b + c + b;
	// so that a == c, which means that a new node moves a steps from head and slow node moves same steps from first 
	// meet position, after equal steps they will meet at the start of the LinkedList cycle;
	// Time: O(n), Space: O(1)
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				ListNode node = head;
				while (node != slow) {
					slow = slow.next;
					node = node.next;
				}
				return slow;
			}
		}
		return null;
	}
}
