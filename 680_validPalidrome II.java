public class validPalidromeII {
	public boolean isValidPalidromeII(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
			}
			i++;
			j--;
		}
		return true;
	}
	
	public boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		validPalidromeII k = new validPalidromeII();
		System.out.println(k.isValidPalidromeII("abac"));
		System.out.println(k.isValidPalidromeII("aba"));
		System.out.println(k.isValidPalidromeII("abacaaaaa"));
	}
}
