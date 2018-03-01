
public class removeDuplicatesFromSortedArray {
	
	//Time: O(n); Space: O(1);
	public int removeDuplicates(int[] nums) {
		int length = nums.length;
		if (length < 2) 	
			return length;
		int index = 1;
		for (int i = 1; i < length; i++) {
			if (nums[i] != nums[i - 1])
				nums[index++] = nums[i];
		}
		return index;
	}
	
	public static void main(String[] args) {
		removeDuplicatesFromSortedArray test = new removeDuplicatesFromSortedArray();
		int[] nums = {1,1,2,2,3,3,4,4,5};
		System.out.println(test.removeDuplicates(nums));
	}
}
