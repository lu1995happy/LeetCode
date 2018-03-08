
public class FirstBadVersion {
	/* The isBadVersion API is defined in the parent class VersionControl.
	boolean isBadVersion(int version); */
	public int firstBadVersion(int n) {
		
		//int start = 1, end = n;
	    //while (start < end) {
	    //    int mid = start + (end-start) / 2;
	    //    if (!isBadVersion(mid)) start = mid + 1;
	    //    else end = mid;            
	    //}        
	    //return start;
		
		if (n == 1){
			if (isBadVersion(n))
				return n;
	        else 
	        		return 0;
	    }
	      
	    int low = 1, high = n, mid = 0;
	    while (low <= high) {
	    		mid = low + (high - low) / 2;
	        if (isBadVersion(mid) && !isBadVersion(mid - 1))
	        		return mid;
	        else 
	        		if (isBadVersion(mid)) 
	        			high = mid -1;
	            else
	            		low = mid + 1;
	    }
	    return mid;
	}
	
	public boolean isBadVersion(int n) {
		return false;
	}
}
