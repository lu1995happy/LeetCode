
public class twoSumII {
	
	// Without HashMap, just have two pointers, A points to index 0, B points to index len - 1,
	// shrink the scope based on the value and target comparison.
	// Time: O(n); Space: O(1);
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		if (numbers == null || numbers.length < 2) 
			return result;
		int i = 0; int j = numbers.length -1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum == target) {
				result[0] = i + 1;
				result[1] = j + 1;
				break;
			} 
			else 
				if (sum > target)
					j--;
				else 
					i++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		twoSumII test = new twoSumII();
		int[] numbers = {2,7,11,15};
		int[] result = test.twoSum(numbers, 9);
		for (int nums: result) {
			System.out.print(nums + " ");
		}
		System.out.println();
	}
}
