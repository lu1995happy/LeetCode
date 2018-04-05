
public class sortColors {
	
	// two pointers;
	// Time: O(n), Space: O(1);
	// only one pass, better than two pass counting sort;
	public void sortColors (int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		int zero = 0, two = nums.length - 1, index = 0;
		while (index <= two) {
			if (nums[index] == 0) {
				swap(nums, index++, zero++);
			} else if (nums[index] == 1) {
				index++;
			} else {
				swap(nums, index, two--);
			}
		}
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
		
	// counting sort;
	// A rather straight forward solution is a two-pass algorithm using counting sort.
	// First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, 
	// then 1's and followed by 2's.
	// Time: O(n), Space: O(1);
	public void sortColors2 (int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		int red = 0; // 0
		int white = 0; // 1
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				red++;
			} else if (nums[i] == 1) {
				white++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (red > 0) {
				nums[i] = 0;
				red--;
			} else if (white > 0) {
				nums[i] = 1;
				white--;
			} else {
				nums[i] = 2;
			}
		}
	}
}
