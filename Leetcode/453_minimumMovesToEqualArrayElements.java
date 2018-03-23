
public class minimumMovesToEqualArrayElements {
	
	// Math problem
	// Time: O(n), Space: O(1);
	// n - 1 elements + 1 == 1 element - 1;
	// sum + moves * (length - 1) = target * length;
	// target = minValue + moves;
	// So : moves = sum - length * minValue;
	public int minMoves (int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int min = Integer.MAX_VALUE, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			min = Math.min(min, nums[i]);
		}
		return sum - nums.length * min;
	}
}
