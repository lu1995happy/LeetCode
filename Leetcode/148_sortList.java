package Algorithm;

public class mergeSortForLinkedList {
	
	//Definition for singly-linked list.
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { 
	    	  	val = x; 
	    	  }
	 }
	 
	// Top-down merge sort implementation using Lists
	// Time: O(nlogn); Space: O(logn) (since using recursion)
	 private ListNode tail;
	 public ListNode sortList(ListNode head) {
		 if (head == null) 
			 return null;
	     else 
	    	 	if (head.next == null) {
	            tail = head;
	            return head;
	        }
	     ListNode biggerListHead = null;
	     ListNode smallerListHead = null;
	     ListNode equalListHead = head;
	     ListNode node = head.next;
	     head.next = null;
	     while (node != null) {
	    	 	ListNode next = node.next;
	        if (node.val == head.val) {
	        		node.next = equalListHead;
	            equalListHead = node;
	        } 
	        else 
	        		if (node.val > head.val) {
	        			node.next = biggerListHead;
	                biggerListHead = node;
	            } 
	        		else {
	                node.next = smallerListHead;
	                smallerListHead = node;                
	            }
	            node = next;
	        }
	        
	        node = head;
	        if (smallerListHead != null) {
	            head = sortList(smallerListHead);
	            tail.next = equalListHead;
	        } 
	        else {
	            head = equalListHead;
	        }
	        if (biggerListHead != null) {
	            node.next = sortList(biggerListHead);
	        } 
	        else {
	            tail = node;
	        }
	        return head;
	    }
	 
	 // Bottom-up merge sort implementation using Lists
	 // Time: O(nlogn); Space: O(1);
	 public ListNode sortedList(ListNode head) {
		 ListNode[] arr = new ListNode[32];
	     ListNode result = head;
	        
	     while (result != null) {
	    	 	ListNode next = result.next;
	        result.next = null;
	        int i;
	            
	        for (i = 0; i < 32 && arr[i] != null; i++) {
	        		result = merge(result, arr[i]);
	            arr[i] = null;
	        }
	            
	        arr[i] = result;
	        result = next;
	     }
	        
	     result = null;
	        
	     for (int i = 0; i < 32; i++) {
	    	 	result = merge(result, arr[i]);
	     }   
	     
	     return result;
	 }
	    
	 private ListNode merge(ListNode headA, ListNode headB) {
		 if (headA == null) {
			 return headB;
	     }
	     if (headB == null) {
	         return headA;
	     }
	        
	     ListNode dummy = new ListNode(0);
	     ListNode curr = dummy;
	     ListNode currA = headA;
	     ListNode currB = headB;
	        
	     while (currA != null || currB != null) {
	    	 	if (currA == null) {
	    	 		curr.next = currB;
	            currB = currB.next;
	        }
	    	 	else 
	    	 		if (currB == null) {
	                curr.next = currA;
	                currA = currA.next;
	            }
	            else {
	                if (currA.val < currB.val) {
	                    curr.next = currA;
	                    currA = currA.next;
	                }
	                else {
	                    curr.next = currB;
	                    currB = currB.next;
	                }
	            }
	            curr = curr.next;
	        }
	        
	    return dummy.next;
	 }
}
