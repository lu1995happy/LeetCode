
public class setMismatch {
	
	// Time: O(n), Space: O(1);
	public int[] findErrorNums (int[] nums) {
		int[] res = new int[2]; // duplicate, missing
		// For each number we found, set nums[number - 1] to its negative value (< 0)
		for (int i = 0; i < nums.length; i++)  {
			// since index starts from 0, and the set starts from 1
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) 
				// have already been found
				res[0] = Math.abs(index) + 1;
			else
				nums[index] *= -1;
		}
		
		// At this point, only nums[missingNumber-1] > 0
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				// since index starts from 0, and the set starts from 1
				res[1] = i + 1;
		}
		return res;
	}
	
	
	// Time: O(n), Space: O(n);
	public int[] findErrorNums2 (int[] nums) {
		int[] res = new int[2];
		int[] count = new int[nums.length + 1];
		if (nums == null || nums.length < 2)
			return res;
		
		int sum = nums.length;
		for (int i = 0; i < nums.length; i++) {
			if (count[nums[i]] > 0)
				res[0] = nums[i];
			sum += i;
			sum -= nums[i];
			count[nums[i]]++;
		}
		res[1] = sum + res[0];
		return res;
	}
}
