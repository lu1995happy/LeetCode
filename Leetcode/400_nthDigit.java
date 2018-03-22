
public class nthDigit {
	
	// Time: < O(n), Space: O(1)
	public int findNthDigit (int n) {
		if (n < 10)
			return n;
		long count = 9;
		int start = 1;
		int length = 1;
		// find the length of the number where the nth digit is from
		while (n > length * count) {
			n -= length * count;
			length++;
			start *= 10;
			count *= 10;
		}
		// find the actual number where the nth digit is from
		start += (n - 1) / length;	
		String s = String.valueOf(start);
		// find the nth digit and return
		return s.charAt((n - 1) % length) - '0';
	}
}
