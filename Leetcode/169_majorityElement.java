import java.util.HashMap;
import java.util.Arrays;

public class majorityElement {
	
	// HashMap function
	// worst time complexity; 
	public int findElement(int[] nums) {
		
		if (nums.length < 2)
			return nums[0];
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int number = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
				if (map.get(nums[i]) > (nums.length / 2))
					number = nums[i];
			}
			else
				map.put(nums[i], 1);
		}
		return number;
	}
	
	// Sort algorithm
	// Time: O(nlogn); same as below and much faster than HashMap;
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
	}
    
    // Boyer-Moore Majority Vote Algorithm
    // Great algorithm: Time: O(n); Space: O(1);
    public int findMajority(int[] nums) {
    		int majority = nums[0];
    		int count = 1;
    		for (int i = 1; i < nums.length; i++) {
    			if (count == 0) {
    				count++;
    				majority = nums[i];
    			}
    			else {
    				if (nums[i] == majority) 
    					count++;
    				else 
    					count--;
    			}
    		}
    		return majority;
    }
	
	public static void main(String[] args) {
		majorityElement test = new majorityElement();
		int[] nums = new int[] {1,2,2,3,3,3,3};
		System.out.println(test.findElement(nums));
		System.out.println(5/2);
	}
}
