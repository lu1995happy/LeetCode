
public class findPermutation {
	
	// Time: O(n), Space: O(n);
	public int[] findPermutation (String s) {
		int[] res = new int[s.length() + 1];
		if (s == null || s.length() == 0)
			return res;
		for (int i = 0; i < res.length; i++) {
			res[i] = i + 1;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'D') {
				int j = i;
				while (i < s.length() && s.charAt(i) == 'D') {
					i++;
				}
				reverse(res, j, i);
			}
		}
		return res;
	}
	
	public void reverse(int[] res, int j, int i) {
		while (j < i) {
			int temp = res[j];
			res[j] = res[i];
			res[i] = temp;
			j++;
			i--;
		}
	}
}
