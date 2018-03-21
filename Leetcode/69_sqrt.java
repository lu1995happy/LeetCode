
public class sqrt {
	
	// Newton method
	// Time: almost constant time;
	public int mySqrt(int x) {
		long num = x; 
		while (num * num > x) {
			num = (num + x / num) / 2;
		}
		return (int) num;
	}
	
	// binary search
	// Time: O(logn);
	public int mySqrt2(int x) {
		int low = 1, high = x;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid == x / mid)
				return mid;
			else if (mid > x / mid) 
				high = mid - 1;
			else 
				low = mid + 1;
		}
		return high;
	}
	
	// Math solution : using 1 + 3 + 5 + 7 = 16
	// Time: O(sqrt(n));
    public int mySqrt3(int x) {
        int i = 1;
        int count = 0;
        while (x > 0) {
            x -= i;
            i += 2;
            count++;
        }
        return x < 0 ? count - 1 : count;
    }
}
