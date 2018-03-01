
public class removeElement {
	
	// Time: O(n); Space: O(1);
	public int removeElements(int[] nums, int target) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != target)
				nums[index++] = nums[i];
		}
		return index;
	}
	
	public static void main(String[] args) {
		removeElement test = new removeElement();
		int[] nums = {1,1,2,2,3,3,4,4,5};
		System.out.println(test.removeElements(nums, 2));
	}
}
