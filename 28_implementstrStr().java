
public class strStr {
	public static int isStrStr(String haystack, String needle) { 
		int m = haystack.length();
		int n = needle.length();
		if (haystack == null || needle == null || n == 0) {
			return 0;
		}
		if (n > m) {
			return -1;
		}
		for (int i = 0; i <= m-n; i++) {
			boolean test = true;
			for (int j = 0; j < n; j++) {
				if (needle.charAt(j) != haystack.charAt(i+j)) {
					test = false;
					break;
				}
			}
			if (test) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(isStrStr("hello", "ll"));
		System.out.println(isStrStr("hhhab", "hab"));
	}
}
