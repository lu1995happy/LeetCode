
public class outputContestMatches {
	
	// Time: O(n), Space: O(n);
	public String findContestMatch (int n) {
		if (n <= 0)
			return "";
		String[] res = new String[n];
		for (int i = 0; i < n; i++) {
			res[i] = String.valueOf(i + 1);
		}
		while (n > 1) {
			for (int i = 0; i < n / 2; i++) {
				res[i] = "(" + res[i] + "," + res[n - i - 1] + ")";
			}
			n /= 2;
		}
		return res[0];
	}
}
