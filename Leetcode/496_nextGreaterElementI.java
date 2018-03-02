import java.util.HashMap;
import java.util.Stack;;


public class nextGreaterElementI {
	
	// Time: O(n), worst case: O(n^2); Space: O(n);
	public int[] nextGreaterElement (int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		// go through each element in nums2 and set its location in HashMap
		for (int i = 0; i < nums2.length; i++) {
			// since every element is unique, there is no need (getOrDefault)
			map.put(nums2[i], i);
		}
		
		// scan each element in the first array    
		for (int i = 0; i < nums1.length; i++) {
			
			// initially, set the finding index to be -1
			int minIndex = -1;
			// find out the corresponding index in the second (nums1) array.
			int index = map.get(nums1[i]);
			while (++index < nums2.length) {
				if (nums2[index] > nums1[i]) {
					minIndex = index;
					break;
				}
			}
			if (minIndex == -1) 
				nums1[i] = -1;
			else 
				nums1[i] = nums2[minIndex];
		}
		return nums1;
	}
	
	public int[] nextElement(int nums1[], int nums2[]) {
		// map from x to next greater element of x
		HashMap<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		
		for (int num : nums2) {
			while (!stack.isEmpty() && stack.peek() < num) 
				map.put(stack.pop(), num);
			stack.push(num);
		}
		
		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = map.getOrDefault(nums1[i], -1);
		}
		return nums1;
	}
	
	public static void main(String[] args) {
		nextGreaterElementI test = new  nextGreaterElementI ();
		int[] nums1 = {2,4};
		int[] nums2 = {1,2,3,4};
		int[] res = test.nextGreaterElement(nums1, nums2);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
	}
}
