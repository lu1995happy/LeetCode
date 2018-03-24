
public class maxConsecutiveOnes {
	
	// Time: O(n), Space: O(1);
	public int findMaxConsecutiveOnes (int[] nums) {
		
		if (nums == null || nums.length == 0)
			return 0;
		int count = 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
				res = Math.max(res, count);
			}
			else 
				count = 0;
		}
		return res;
	}
}
