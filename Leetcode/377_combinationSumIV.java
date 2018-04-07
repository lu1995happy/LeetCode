import java.util.HashMap;
import java.util.Map;

public class combinationSumIV {
	
	// Now for a DP solution, we just need to figure out a way to store the intermediate results, to avoid the same 
	// combination sum being calculated many times. We can use an array to save those results, and check if there is 
	// already a result before calculation. We can fill the array with -1 to indicate that the result hasn’t been 
	// calculated yet. 0 is not a good choice because it means there is no combination sum for the target.
	public int combinationSum4 (int[] nums, int target) {
	    int[] res = new int[target + 1];
	    res[0] = 1;
	    for (int i = 1; i < res.length; i++) {
	        for (int j = 0; j < nums.length; j++) {
	            if (i - nums[j] >= 0) {
	                res[i] += res[i - nums[j]];
	            }
	        }
	    }
	    return res[target];
	}
	
	// for follow-up : 
	// In order to allow negative integers, the length of the combination sum needs to be restricted, or the search 
	// will not stop. 
	Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
       
    public int combinationSum42(int[] nums, int target, int MaxLen) {
        if (nums == null || nums.length ==0 || MaxLen <= 0 ) 
        		return 0;
        map = new HashMap<>();
        return helper(nums, 0, target, MaxLen);
    }
    
    private int helper(int[] nums, int len, int target, int MaxLen) {
    		int count = 0;
        if (len > MaxLen) 
        		return 0;
        if (map.containsKey(target) && map.get(target).containsKey(len)) { 
        		return map.get(target).get(len);
        }
        if (target == 0)   
        		count++;
        for (int num: nums) {
            count += helper(nums, len + 1, target - num, MaxLen);
        }
        if (!map.containsKey(target)) 
        		map.put(target, new HashMap<Integer,Integer>());
        Map<Integer,Integer> mem = map.get(target);
        mem.put(len, count);
        return count;
    }
    
	// Think about the recurrence relation first. How does the # of combinations of the target related to the # of 
	// combinations of numbers that are smaller than the target? So we know that target is the sum of numbers in the 
	// array. Imagine we only need one more number to reach target, this number can be any one in the array, right? 
	// So the # of combinations of target, comb[target] = sum(comb[target - nums[i]]), where 0 <= i < nums.length, and 
	// target >= nums[i]. In the example given, we can actually find the # of combinations of 4 with the # of combinations 
	// of 3(4 - 1), 2(4- 2) and 1(4 - 3). As a result, comb[4] = comb[4-1] + comb[4-2] + comb[4-3] = comb[3] + comb[2] + 
	// comb[1]. Then think about the base case. Since if the target is 0, there is only one way to get zero, which is 
	// using 0, we can set comb[0] = 1. EDIT: The problem says that target is a positive integer that makes me feel 
	// it’s unclear to put it in the above way. Since target == 0 only happens when in the previous call, 
	// target = nums[i], we know that this is the only combination in this case, so we return 1.
	public int combinationSum4_2 (int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (target == 0) {
			return 1;
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target >= nums[i]) {
				res += combinationSum4(nums, target - nums[i]);
			}
		}
		return res;
	}
}
