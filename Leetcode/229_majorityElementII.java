import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class majorityElementII {
	
	// Time: O(n); Space: O(1);
	// Boyer-Moore Majority Vote Algorithm
	
	// 1. there are no elements that appears more than n/3 times, then whatever the algorithm 
	// got from 1st round wound be rejected in the second round.
	
	// 2. there are only one elements that appears more than n/3 times, after 1st round one of 
	// the candidate must be that appears more than n/3 times(<2n/3 other elements could only
	// pair out for <n/3 times), the other candidate is not necessarily be the second most frequent 
	// but it would be rejected in 2nd round.
	
	// 3. there are two elements appears more than n/3 times, candidates would contain both of
	// them. (<n/3 other elements couldn't pair out any of the majorities.)
	public List<Integer> majorityElement(int[] nums) {
		
		List<Integer> list = new ArrayList<>();
		
		if (nums.length == 0) 
			return list;
		
		int num1 = nums[0];
		int num2 = nums[0];
		int count1 = 0;
		int count2 = 0;
		
		for (int num : nums) {
			if (num == num1)
				count1++;
			else if (num == num2)
					count2++;
			else if (count1 == 0) {
					num1 = num;
					count1++;
				 } 
			else if (count2 == 0) {
					num2 = num;
					count2++;
				 }
			else {
					count1--;
					count2--;
				}
		}
		
		count1 = 0;
		count2 = 0;
		for (int num: nums) {
			if (num == num1) 
				count1++;
			else if (num == num2)
				count2++;
		}
		
		if (count1 > nums.length / 3)
			list.add(num1);
		if (count2 > nums.length / 3)
			list.add(num2);
		
		return list;
	}
	
	// for n/k questions; 
	// Good to learn;
	public List<Integer> majorityKElement(int[] nums) {
        int n = nums.length, k = 3;  //in this question, k=3 specifically
        List<Integer> result = new ArrayList<Integer>();
        if (n==0 || k<2) return result;
        int[] candidates = new int[k-1];
        int[] counts = new int[k-1];
        for (int num: nums) {
            boolean settled = false;
            for (int i=0; i<k-1; i++) {
                if (candidates[i]==num) {
                    counts[i]++;
                    settled = true;
                    break;
                } 
            }
            if (settled) 
            		continue;
            for (int i=0; i<k-1; i++) {
                if (counts[i]==0) {
                    counts[i] = 1;
                    candidates[i] = num;
                    settled = true;
                    break;
                } 
            }
            if (settled) 
            		continue;
            for (int i=0; i<k-1; i++) 
            		counts[i] = (counts[i] > 0) ? (counts[i]-1) : 0;
        }
        
        Arrays.fill(counts, 0);
        for (int num: nums) {
            for (int i=0;i<k-1; i++) {
                if (candidates[i]==num) {
                    counts[i]++;
                    break;
                }
            }
        }
        for (int i=0; i<k-1; i++) 
        		if (counts[i]>n/k) 
        			result.add(candidates[i]);
        return result;
    }
}
