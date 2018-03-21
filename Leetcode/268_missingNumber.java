
public class missingNumber {
	// method 1: sort and using binary search; Time: O(nlogn), Space: O(1), if sorted array, Time: O(logn);
	// method 2: HashSet; Time: O(n), Space: O(n);
	// method 3: Bit Manipulation: XOR function; Time: O(n), Space: O(1);
	// method 4: Math, using expectedSum and actualSum; Time: O(n), Space: O(1);
	
	// a number XOR itself will become 0, any number XOR with 0 will stay unchanged.
	public int missingNumber(int[] nums) {
		int res = nums.length;
		for (int i = 0; i < nums.length; i++) {
			res ^= nums[i] ^ i;
		}
		return res;
	}
	
	// method 4
	public int missingNumber1(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += i;
			sum -= nums[i];
		}
		sum += nums.length;
		return sum; 
	}
}
