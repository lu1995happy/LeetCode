
public class singleNumber {
	
	// 0 XOR A = A; 
	// A XOR A = 0;
	// Using bit manipulation;
	// Time: O(n); Space: O(1);
	public int isSingleNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result ^= nums[i];
		}
		return result;
	}
}
