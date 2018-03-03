import java.util.Arrays;

public class superUglyNumber {
	
	// Time: O(nk);
	public int nthSuperUglyNumber(int n, int[] primes) {
		
		if (n == 1)
			return 1;
		
		int[] res = new int[n];
		int[] count = new int[primes.length];
		int[] val = new int[primes.length];
		Arrays.fill(val, 1);
		int next = 1;
		
		for (int i = 0; i < n; i++) {
			res[i] = next;
			next = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				// skip duplicate and avoid extra multiplication
				if (res[i] == val[j])
					val[j] = res[count[j]++] * primes[j];
				// find next ugly number
				next = Math.min(val[j], next);
			}		
		}
		return res[n-1];
	}
}
