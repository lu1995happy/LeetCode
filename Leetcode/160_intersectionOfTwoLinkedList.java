package LinkedList;

public class intersectionOfTwoLinkedList {
	//I found most solutions here preprocess linkedlists to get the difference in length.
	//Actually we don’t care about the “value” of difference, we just want to make sure two 
	//pointers reach the intersection node at the same time.
    //We can use two iterations to do that. 
	//In the first iteration, we will reset the pointer of one linkedlist to the head of another linkedlist after it reaches the tail node. 
	//In the second iteration, we will move two pointers until they points to the same node. 
	//Our operations in first iteration will help us counteract the difference. 
	//So if two linkedlist intersects, the meeting point in second iteration must be the intersection point. 
	//If the two linked lists have no intersection at all, then the meeting pointer in second iteration must be the tail node of both lists, which is null
	public Node checkIntersection(Node headA, Node headB) {
		//boundary check
		if (headA == null || headB == null) {
			return null;
		}
		Node a = headA;
		Node b = headB;
		//if a & b have different length, then we will stop the loop after second iteration
		while (a != b) {
			//for the end of first iteration, we just reset the pointer to the head of another Linkedlist
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}
	
	public Node computeIntersectionPoint(Node a, Node b) {
		int lengthA = computeLength(a);
		int lengthB = computeLength(b);
		while (lengthA < lengthB) {
			b = b.next;
			lengthB--;
		}
		while (lengthA > lengthB) {
			a = a.next;
			lengthA--;
		}
		while (a != b) {
			a = a.next;
			b = b.next;
		}
		return a;
	}
	
	public int computeLength(Node a) {
		int length = 0;
		while (a != null) {
			a = a.next;
			length++;
		}
		return length;
	}
}
