
public class reverseBits {
	
	// Time: O(1), Space: O(1);
	
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		if (n == 0)
			return 0;
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res <<= 1; // move 1 bits left
			res += n & 1; // n & 1 == 1 if n = 1 , = 0 if n = 0;
			n >>= 1; // move 1 bit right
		}
		return res;
	}
}
