import java.util.Arrays;
import java.util.HashMap;

public class relativeRanks {
	
	// sorting method
	// Time: O(nlogn), Space: O(n);
	public String[] findRelativeRanks (int [] nums) {
		String[] res = new String[nums.length];
		if (nums == null || nums.length == 0)
			return res;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) 
			map.put(nums[i], i);
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i == nums.length - 1)
				res[map.get(nums[i])] = "Gold Medal";
			else if (i == nums.length - 2)
				res[map.get(nums[i])] = "Silver Medal";
			else if (i == nums.length - 3)
				res[map.get(nums[i])] = "Bronze Medal";
			else 
				res[map.get(nums[i])] = nums.length - i + "";
		}
		return res;
	}
	
	// Time: O(n), Space: O(n);
	// using array to simple do the sorting stuff;
    public String[] findRelativeRanks2(int[] nums) {
         String[] result = new String[nums.length];
         // get the max number in order to create the array that will fills all the numbers;
         int max = 0;
         for (int i : nums) {
             if (i > max) max = i;
         }
         // create a array to store the number in increasing order and its index;
         int[] hash = new int[max + 1];
         for (int i = 0; i < nums.length; i++) {
             hash[nums[i]] = i + 1;
         }
         // store the position for each number;
         int place = 1;
         // iterative from the largest number, fill the result array;
         for (int i = hash.length - 1; i >= 0; i--) {
             if (hash[i] != 0) {
                 if (place == 1) {
                     result[hash[i] - 1] = "Gold Medal";
                 } else if (place == 2) {
                     result[hash[i] - 1] = "Silver Medal";
                 } else if (place == 3) {
                     result[hash[i] - 1] = "Bronze Medal";
                 } else {
                     result[hash[i] - 1] = String.valueOf(place);
                 }
                 place++;
             }
         }
         return result;
     }
	
	public static void main (String[] args) {
		relativeRanks test = new relativeRanks();
		int[] nums = {1,2,3,4,5};
		String[] res = test.findRelativeRanks(nums);
		for (String s : res)
			System.out.print(s);
	}
}
