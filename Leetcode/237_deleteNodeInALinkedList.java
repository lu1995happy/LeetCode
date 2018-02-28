package LinkedList;

public class deleteNode {
	public Node deleteNode(Node node) {
        // if the node is tail case;
        if (node != null && node.next != null) {
            // give the next value to previous one and delete the next node;
            node.val = node.next.val;
            node.next = node.next.next;
        }
        return node;
    }
}
