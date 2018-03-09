
public class reverseInteger {
	
	// Time: O(n), Space: O(1)
	// Integer range: -2^32 --- 2^32-1
	// use long to define the overflow, corner case
	public int reverse(int x) {
		long res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x /= 10;
			if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
				return 0;
		}
		return (int) res;
	}
}
