import java.util.Arrays;
import java.util.Random;

public class KthLargestElementInAnArray {
	// Java program to find k'th largest element in expected O(n) time
	// using randomized QuickSort based method. 
	public int kthLargest(int[] nums, int k) {
		shuffle(nums);
	    k = nums.length - k;
	    int lo = 0;
	    int hi = nums.length - 1;
	    while (lo < hi) {
	    		int j = partition(nums, lo, hi);
	        if(j < k) 
	        		lo = j + 1;
	        else if (j > k) 
	             hi = j - 1;
	        else
	             break;
	    }
	    return nums[k];
	}
	
	private int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }
    
    private void shuffle(int a[]) {
        Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }
  
	// Time: O(nlogn), Space: O(1);
	public int findKthElement (int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
}
