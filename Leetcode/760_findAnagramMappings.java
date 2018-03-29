import java.util.HashMap;

public class findAnagramMappings {
	
	// Time: O(n), Space: O(n);
	public int[] anagramMappings (int[] A, int[] B) {
		int[] res = new int[A.length];
		if (A == null || B == null || A.length == 0 || B.length == 0 || A.length != B.length) 
			return res;
		// Since this problem accepts any possible answers, if only accept one answer, we could use
		// HashMap<Integer, ArrayList<Integer>> map to handle this, and remove one after get one;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < B.length; i++) {
			map.put(B[i], i);
		}
		for (int i = 0; i < A.length; i++) {
			res[i] = map.get(A[i]);
		}
		return res;
	}
}
