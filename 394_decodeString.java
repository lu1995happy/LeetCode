/* 
 * Leetcode 394
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
 * Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. 
 * For example, there won't be input like 3a or 2[4].
 * 
 * Example:
 * 1. Input: s = "3[a]2[bc]"
 *    Output: return "aaabcbc"
 * 
 * 2. Input: s = "3[a2[c]]"
 *    Output: return "accaccacc"
 *    
 * 3. Input: s = "2[abc]3[cd]ef"
 *    Output: return "abcabccdcdcdef"
 */

import java.util.Stack;

public class decodeString {
	public static String isDecodeString(String s) {
		Stack<Integer> intStack = new Stack<>();
		Stack<StringBuilder> strStack = new Stack<>();
		StringBuilder result = new StringBuilder();
		int k = 0;
		for (char ch: s.toCharArray()) {
			if (Character.isDigit(ch)) {
				k = k * 10 + ch - '0'; 
			}
			else if (ch == '[') {
				intStack.push(k);
				strStack.push(result);
				result = new StringBuilder();
				k = 0;
			} 
			else if (ch == ']') {
				StringBuilder tmp = new StringBuilder(result);
				result = strStack.pop();
			    int count = intStack.pop();
				for (int i = 0; i < count; i++) {
					result.append(tmp);
				}
			}
			else result.append(ch);
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(isDecodeString("ab3[abc]"));
	}
}
