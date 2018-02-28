/* 
 * Leetcode 686
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. 
 * If no such solution, return -1.
 * For example, with A = "abcd" and B = "cdabcdab".
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; 
 * and B is not a substring of A repeated two times ("abcdabcd").
 * 
 * Note:
 * The length of A and B will be between 1 and 10000.
 */

public class repeatedStringMatch {
	public static int isRepeatedStringMatch (String a, String b) {
		if (a.contains(b)) {
			return 1;
		} else {
			if ((a+a).contains(b)) {
				return 2;
			}
		}
		int count = 1;
		String s = a;
		while (!(s.contains(b))) {
			if (s.length() - a.length() > b.length()) {
				return -1;
			}
			s += a;
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(isRepeatedStringMatch("abcd","cdabcdab"));
		System.out.println(isRepeatedStringMatch("abc","dcc"));
		System.out.println(isRepeatedStringMatch("a","a"));
		System.out.println(isRepeatedStringMatch("aa","a"));
	}
}
