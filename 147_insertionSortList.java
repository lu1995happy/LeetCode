package Algorithm;

// 1) Create an empty sorted (or result) list
// 2) Traverse the given list, do following for every node.
      // a) Insert current node in sorted way in sorted or result list.
// 3) Change head of given linked list to head of sorted (or result) list.

//Time: O(n^2), Space: O(1);

public class insertionSortForLinkedList {
	
	ListNode sorted;
	ListNode head;
	
	 //Definition for singly-linked list.
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { 
	    	  	val = x; 
	    	  }
	 }
	 
	 // function to sort a singly linked list using insertion sort
	 public ListNode InsertionSort(ListNode head) {
		 
		 if (head == null) {
			 return head;
		 }
		 
		// new starter of the sorted list
		 ListNode sorted = new ListNode(0);
		// the node will be inserted
		 ListNode curr = head;
		// insert node between prev and prev.next
		 ListNode prev = sorted;
		// the next node will be inserted
		 ListNode next = null; 
		// not the end of input list
		 while (curr != null) {
			 next = curr.next; 
			 if(prev != null || prev.next != null || prev.next.val >= curr.val)
				 prev = sorted;
			// find the right place to insert
			 while (prev.next != null && prev.next.val < curr.val) {
				 prev = prev.next;
			 }
			 
			// insert between prev and prev.next
			 curr.next = prev.next;
			 prev.next = curr;
			 //prev = sorted;
			 curr = next;
		 }		 
		 return sorted.next;
	 }
	 
	 public void push(int val) {
		 // allocate node
		 ListNode node = new ListNode(val);
		 // link the old list off the new node
		 node.next = head;
		 // move the head to point to the new node
		 head = node;
	 }
	 
	 // Function to print linked list
	 public void printlist(ListNode head) {
		 while (head != null) {
			 System.out.print(head.val + " ");
	         head = head.next;
	     }
	 }
	     
	 // Driver program to test above functions
	 public static void main(String[] args) {
		 insertionSortForLinkedList list = new insertionSortForLinkedList();
	     list.push(5);
	     list.push(20);
	     list.push(4);
	     list.push(3);
	     list.push(30);
	     
	     System.out.println("Linked List before Sorting..");
	     list.printlist(list.head);
	     list.InsertionSort(list.head);
	     System.out.println("\nLinkedList After sorting");
	     list.printlist(list.head);
	 }
}
