
public class powerOfThree {
	
	public boolean isPowerOfThree(int n) {
		
	// recursive solution
	// return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree(n / 3)));
	
	// iterative solution
	//    if (n > 1)
    //    	while (n % 3 == 0) 	
	// 	    		n /= 3;
    //    return n == 1;
	
	// Math solution
	// since maxPowerOfThree = 1162261467
	// only works for prime
	// return n > 0 && (1162261467 % n == 0);
	
	// works for all	
	return (Math.log10(n) / Math.log10(3)) % 1 == 0;
	
	// works for all
	// return n == 0 ? false : n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
	}
}
