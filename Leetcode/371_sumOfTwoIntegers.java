
public class sumOfTwoIntegers {
	public int getSum(int a, int b) {
		
		// Bit Manipulation
		// get sum
		// return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
		
		// get subtract
		// return b == 0 ? a : getSubtract(a ^ b, (~a & b) << 1);
		// iterative solution
		// Time: O(n) / O(1), Space: O(1)
		if (a == 0) 
			return b;
		if (b == 0)
			return a;
		while (b != 0) {
			// only both "1" = 1;
			int carry = a & b;
			// different values = 1; same values = 0;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}
}
