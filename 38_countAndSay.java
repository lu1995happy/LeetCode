/*
 * Leetcode: 38
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.  1
 * 2.  11
 * 3.  21
 * 4.  1211 
 * 5.  111221
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 * Example:
 * 
 * 1. Input: 1
 *    Output: "1"
 *    
 * 2. Input: 4 
 *    Output: "1211"  
 */

public class countAndSay {
	public static String isCountAndSay(int n) {
		if (n < 0) {
			return "";
		}
		StringBuilder result = new StringBuilder("1");
		for (int i = 1; i < n; i++) {
			int count = 1;
			StringBuilder prev = new StringBuilder(result);
			result = new StringBuilder();
			char say = prev.charAt(0);
			for (int j = 1; j < prev.length(); j++) {
				if (!(prev.charAt(j) == prev.charAt(j-1))) {
					result.append(count).append(say);
					count = 1;
					say = prev.charAt(j);
				}
				else count++;
			}
			result.append(count).append(say);
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(isCountAndSay(1));
		System.out.println(isCountAndSay(4));
		System.out.println(isCountAndSay(10));
	}
}
