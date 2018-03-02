
public class removeDuplicatesFromSortedArrayII {
	
	// Time: O(n); Space: O(1);
	public int removeDuplicates(int[] nums) {
		
		//int i = 0;
		//for (int number: nums) 
		//	if (i < 2 || nums[i-2] < number)
		//		nums[i++] = number;
		//return i;
		
		if (nums == null)
			return 0;
		
		if (nums.length < 2) 
			return nums.length;
		
		int count = 1;
		int number = nums[0];
		int pos = 1;
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == number) {
				count++;
				if (count <= 2) 
					nums[pos++] = number;
			}
			else {
				number = nums[i];
				count = 1;
				nums[pos++] = number;
			}
		}
		return pos;
	}
	
	public static void main(String[] args) {
		removeDuplicatesFromSortedArrayII test = new removeDuplicatesFromSortedArrayII();
		int[] nums = {1,1,1,1};
 		System.out.println(test.removeDuplicates(nums));
	}
}
