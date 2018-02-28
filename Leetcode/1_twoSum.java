/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Example:
 * Input: Given nums = [2, 7, 11, 15], target = 9
 * Output: return [0, 1]
 * Hint: Because nums[0] + nums[1] = 2 + 7 = 9
 */

import java.util.HashMap;
import java.util.Map;

public class twoSum {
	//Brute Force
	public static int[] isTwoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					return new int[] {i,j};
				}
			}
		}
		throw new IllegalArgumentException("No such solution");
	}
	
	//Hashmap
	public static int[] wasTwoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int component = target - nums[i];
			if (map.containsKey(component)) {
				return new int[] {map.get(component), i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No such solution");
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		System.out.println(isTwoSum(a,5));
	}
}
