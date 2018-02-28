
public class countBinarySubstrings {
	public static int isCountBinarySubstrings(String s) {
		int prev = 0;
		int curr = 1;
		int count = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i-1)) {
				curr++;
			} else {
				prev = curr;
				curr = 1;
			}
			if (prev >= curr) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(isCountBinarySubstrings("11001100"));
		System.out.println(isCountBinarySubstrings("10101"));
	}
}
