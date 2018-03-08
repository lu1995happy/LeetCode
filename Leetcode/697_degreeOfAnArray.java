import java.util.HashMap;

public class degreeOfAnArray {
	public int findShortestSubArray (int[] nums) {
		HashMap<Integer, Integer> freq = new HashMap<>();
		HashMap<Integer, Integer[]> pos = new HashMap<>();
		int degree = 0, length = nums.length;
		for (int i = 0; i < nums.length; i++) {
			freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
			//if (freq.get(nums[i]) == null) {
			//	freq.put(nums[i], 1);
			//}
			//else {
			//	int numbe'r = freq.get(nums[i]);
			//	number++;
			//	freq.put(nums[i], number);
			//
			degree = Math.max(degree, freq.get(nums[i]));
			
			if (pos.get(nums[i]) == null)
				pos.put(nums[i], new Integer[2]);
			Integer[] range = pos.get(nums[i]);
			if (range[0] == null) 
				range[0] = i;
			range[1] = i;
			//pos.put(nums[i], range);
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (freq.get(nums[i]) != degree)
				continue;
			Integer[] range = pos.get(nums[i]);
			length = Math.min(length, range[1] - range[0] + 1);
		}
		return length;
	}
	
	public int findShortestArray(int[] nums) {
		
		// base case
		if (nums == null || nums.length <= 1)
			return nums.length;
		
		// define the length of start, end, freq array
		int maxNumber = 0;
		for (int num : nums)
			maxNumber = Math.max(maxNumber, num);
		int[] start = new int[maxNumber + 1];
		int[] end = new int[maxNumber + 1];
		int[] freq = new int[maxNumber + 1];
		
		// store the start, end position and freq of a number
		for (int i = 0; i < nums.length; i++) {
			if (freq[nums[i]] == 0) 
				start[nums[i]] = i;
			end[nums[i]] = i;
			freq[nums[i]]++;
		}
		
		// find the maxFreq of the array
		int maxFreq = 0;
		for (int num : freq) 
			maxFreq = Math.max(maxFreq, num);
		
		// find the minLength of the right subArray;
		int length = nums.length;
		for (int i = 0; i < nums.length; i++) {
			if (freq[nums[i]] == maxFreq)
				length = Math.min(length, end[nums[i]] - start[nums[i]] + 1);
		}
		return length;
	}
	
	public static void main(String[] args) {
		degreeOfAnArray test = new degreeOfAnArray();
		int[] nums = new int[] {1,2,2,3,1,4,2};
		System.out.println(test.findShortestArray(nums));
	}
}
