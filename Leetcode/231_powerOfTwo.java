
public class powerOfTwo {
	public boolean isPowerOfTwo(int n) {
		
	// recursive solution, Time: O(logn)
	// return n > 0 && (n == 1 || (n % 2 == 0 && isPowerOfThree(n / 2)));
	
	// iterative solution, Time: O(logn)
	//    if (n > 1)
    //    	while (n % 2 == 0) 	
	// 	    		n /= 2;
    //    return n == 1;

	// bit operation, Time: O(1)
	// since power of two means only one bit of n is "1"
	return n > 0 && ((n & (n - 1)) == 0);
	
	// works for all	
	// return (Math.log10(n) / Math.log10(4)) % 1 == 0;
	
	// works for all
	// return n == 0 ? false : n == Math.pow(4, Math.round(Math.log(n) / Math.log(4)));
	}
}
