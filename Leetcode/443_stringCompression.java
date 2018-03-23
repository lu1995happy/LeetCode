public class stringCompression {
	
	// create the compressed string first
	// then return the shorter of the input string and the compressed string
	// Time: O(n); Space: O(1) - In place
	public int compress(char[] chars) {
		if (chars == null || chars.length == 0)
			return 0;
		int start = 0, end = 0, index = 0;
		while (end < chars.length) {
			int count = 0;
			while (end < chars.length && chars[end] == chars[start]) {
				count++;
				end++;
			} 
			chars[index++] = chars[start];
			if (count > 1) {
				char[] len = String.valueOf(count).toCharArray();
				for (int i = 0; i < len.length; i++) {
					chars[index++] = len[i];
				}
			}
			start = end;
		}
		return index;
	}
}
