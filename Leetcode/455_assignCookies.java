import java.util.Arrays;

public class assignCookies {
	
	// Time: O(nlogn), Space: O(1);
	// Greedy Algorithm
	// Also can use TreeMap, same runtime;
	public int findContentChildren (int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int count = 0, start = 0;
		// Time: O(m + n)
		while (start < s.length && count < g.length) {
			if (g[count] <= s[start]) {
				count++;
				start++;
			} else 
				start++;
		}
		return count;
	}
}
