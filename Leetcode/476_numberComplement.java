
public class numberComplement {
	// Time: O(1), Space: O(1);
	public int findComplement (int num) {
		// To create a mask that the highest bit of num is 1, others are 0; 
		// Example : num = 5 (101), mask = 100, mask - 1 = 011, ~num = 010, & only both 1 = 1, others = 0;
		int mask = Integer.highestOneBit(num) - 1;
	    return ~num & mask; // num ^((Integer.highestOneBit(num) << 1) - 1);
	    // ~num & ((Integer.highestOneBit(num) << 1) - 1) = num ^ ((Integer.highestOneBit(num) << 1) - 1)
	}
}
