package LinkedList;

import LinkedList.Node;

public class removeLinkedListElements {
	public Node removeElements(Node head, int val) {
		if (head == null) 
			return null;
		head.next = removeElements(head.next, val);
		return head.val == val ? head.next : head;
	}
	
	public Node deleteElements(Node head, int val) {
		Node dummy = new Node(0);
		dummy.next = head;
		Node curr = dummy;
		while (curr.next != null) {
			if (curr.next.val == val) 
				curr.next = curr.next.next;
			else
				curr = curr.next;
		}
		return dummy.next;
	}
	
	public Node cancelElements(Node head, int val) {
		Node fakeHead = new Node(0);
		fakeHead.next = head;
		Node curr = head;
		Node prev = fakeHead;
		while (curr != null) {
			if (curr.val == val) 
				prev.next = curr.next;
			else 
				prev = prev.next;
			curr = curr.next;
		}
		return fakeHead.next;
	}
}

