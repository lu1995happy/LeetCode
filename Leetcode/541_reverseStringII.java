
public class reverseStringII {
	
	// Time: O(n), Space: O(1);
	public String reverseStr (String s, int k) {
		if (s == null || s.length() == 0) 
			return "";
		char[] ch = s.toCharArray();
		int n = ch.length;
		int i = 0;
		while (i < n) {
			int j = Math.min(i + k - 1, n - 1);
			swap(ch, i, j);
			i += 2 * k;
		}
		return String.valueOf(ch);
	}
	
	public void swap (char[] ch, int i, int j) {
		while (i < j) {
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j]= temp;
			i++;
			j--;
		}
	}
}
