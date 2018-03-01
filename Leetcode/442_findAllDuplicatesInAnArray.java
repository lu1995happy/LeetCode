import java.util.ArrayList;
import java.util.List;

public class findAllDuplicatesInAnArray {
	
	// when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
	// Time: O(n); Space: O(1);
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0)
				res.add(index+1);
			nums[index] = -nums[index];
		}
		return res;
	}
	
	public static void main(String[] args) {
		findAllDuplicatesInAnArray test = new findAllDuplicatesInAnArray();
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(test.findDuplicates(nums));
	}
}
