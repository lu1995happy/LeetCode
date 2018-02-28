public class longestCommonPrefix {
	public String isLongestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String pre = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(pre) != 0) {
				pre = pre.substring(0, pre.length() - 1);
			}
		}
		return pre;
	}
	
	public static void main(String[] args) {
		longestCommonPrefix l = new longestCommonPrefix();
		System.out.println(l.isLongestCommonPrefix(new String[]{"aaaa","aaa","aaaa","aaaaaaa","b"}));
	}
}
