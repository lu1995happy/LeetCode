import java.util.Arrays;

public class arrayPartitionI {
	
	// the goal is to return the largest possible sum of min of the pairs;
	// so we need to make the pair difference as small as possible to make the result large;
	// that's why we should sort the numbers so that add each odd number is the result;
	
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int result = 0;
		for (int i = 0; i < nums.length; i += 2) {
			result += nums[i];
		}
		return result;
	}
}
