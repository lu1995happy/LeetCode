
public class validPerfectSquare {
	
	// binary search
	// Time: O(logn), Space: O(1);
	public boolean isPerfectSquare(int num) {
		int low = 1, high = num;
		while (low <= high) {
			// use long to avoid mid * mid overflow
			// >>1 is same as /2;
			long mid = low + (high - low) / 2;
			if (mid * mid == num) 
				return true;
			else if (mid * mid < num)
				low = (int) mid + 1;
			else high = (int) mid - 1;
		}
		return false;
	}
	
	// Newton method
	// Time Complexity is close to constant
	public boolean isPerfectSquare2(int num) {
		long x = num;
		while (x * x > num) {
			x = (x + num / x) / 2;
		}
		return x * x == num;
	}
	
	// Math method : 1 + 3 + 5 + 7 = 16
	// Time: O(sqrt(n));
	public boolean isPerfectSquare3(int num) {
		int i = 1;
		while (num > 0) {
			num -= i;
			i += 2;
		}
		return num == 0;
	}
	
	// brute force
	// Time: O(n), Space: O(1)
	public boolean isPerfectSquare4(int num) {
		if (num < 1)
			return false;
		if (num == 1)
			return true;
		for (int i = 1; i <= num / i; i++) {
			if (i * i == num)
				return true;
		}
		return false;
	}
	
}
