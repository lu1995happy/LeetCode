
public class reverseWordsInAStringIII {
	
	//Time: O(n); Space: O(n);
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		String[] res = s.split("\\s+");// String[] res = s.split(" ");
		for (int i = 0; i < res.length; i++) {
		//	res[i] = new StringBuilder(res[i]).reverse().toString();
			sb.append(res[i]);
			result.append(sb.reverse() + " ");
			sb = new StringBuilder();
		}
		//for (String str : res)
		//	result.append(str + " ");
		return result.toString().trim();
	}
	
	public static void main(String[] args) {
		reverseWordsInAStringIII test = new reverseWordsInAStringIII();
		System.out.println(test.reverseWords("Let's take LeetCode contest"));
	}
}
