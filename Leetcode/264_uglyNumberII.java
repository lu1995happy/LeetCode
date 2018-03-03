
public class uglyNumberII {
	public int nthUglyNumber(int n) {
		
		// The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
		// because every number can only be divided by 2, 3, 5, one way to look at the sequence
		// is to split the sequence to three groups as below:
		// (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
		// (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
		// (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
		// We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) 
		// multiply 2, 3, 5. Then we use similar merge method as merge sort, to get every ugly number 
		// from the three subsequence.
		// Every step we choose the smallest one, and move one step after,including nums with same value.
		int[] res = new int[n];
		res[0] = 1;
		int index2 = 2, index3 = 3, index5 = 5;
		int count2 = 0, count3 = 0, count5 = 0;
		for (int i = 1; i < n; i++) {
			int min = Math.min(index2, Math.min(index3, index5));
			res[i] = min;
			if (index2 == min)
				index2 = res[++count2] * 2;
			if (index3 == min)
				index3 = res[++count3] * 3;
			if (index5 == min)
				index5 = res[++count5] * 5;
		}
		return res[n-1];
	}
	
	public static void main(String[] args) {
		uglyNumberII test = new uglyNumberII();
		System.out.println(test.nthUglyNumber(6));
	}
}
