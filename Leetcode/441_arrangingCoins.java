
public class arrangingCoins {
	
	// Time: O(n), Space: O(1);
	public int arrangeCoins (int n) {
		if (n < 2)
			return n;
		int i = 1, count = 0;
		while (n - i >= 0) {
			n -= i;
			i++;
			count++;
		}
		return count;
	}
}
