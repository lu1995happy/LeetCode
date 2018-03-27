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
	public static int repeatedStringMatch (String a, String b) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while (sb.length() < b.length()) {
			sb.append(a);
			count++;
		}
		if (sb.toString().contains(b))
			return count;
		if (sb.append(a).toString().contains(b))
			return ++count;
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(repeatedStringMatch("abcd","cdabcdab"));
		System.out.println(repeatedStringMatch("abc","dcc"));
		System.out.println(repeatedStringMatch("a","a"));
		System.out.println(repeatedStringMatch("aa","a"));
	}
}
