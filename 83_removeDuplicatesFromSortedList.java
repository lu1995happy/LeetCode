package LinkedList;

public class removeDuplicatesFromSortedList {
	public Node removeDuplicate(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		node.next = removeDuplicate(node.next);
		return node.val == node.next.val ? node.next : node;
	}
	
	public Node deleteDuplicate(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		Node head = node;
		while (head.next != null) {
			if (head.val == head.next.val) {
				head.next = head.next.next;
			}
			else 
				head = head.next;
		}
		return node;
	}
}
