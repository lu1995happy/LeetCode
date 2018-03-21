
public class powerOfFour {
	
	public boolean isPowerOfFour(int n) {
		
	// recursive solution
	// return n > 0 && (n == 1 || (n % 4 == 0 && isPowerOfThree(n / 4)));
	
	// iterative solution
	//    if (n > 1)
    //    	while (n % 4 == 0) 	
	// 	    		n /= 4;
    //    return n == 1;

	// works for all	
	return (Math.log10(n) / Math.log10(4)) % 1 == 0;
	
	// works for all
	// return n == 0 ? false : n == Math.pow(4, Math.round(Math.log(n) / Math.log(4)));
	}
}
