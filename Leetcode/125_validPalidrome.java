public class isPermutationI {
	public boolean isPermutation(String s) {
		//Base case
		if (s.length() == 0) {
			return true;
		}
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			char ch1 = s.charAt(i);
			char ch2 = s.charAt(j);
			if (!(Character.isLetterOrDigit(ch1))) {
				i++;
			} else {
				if (!(Character.isLetterOrDigit(ch2))) {
					j--;
				} else {
					if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
						return false;
					}
					i++;
					j--;
				}
			}
		}
		return true;
	}
	
	public boolean isPalindrome(String s) {
		String actual = s.replaceAll("[^a-z0-9A-Z]", "").toLowerCase();
		StringBuilder sb = new StringBuilder(actual).reverse();
		return actual.equals(sb.toString());
	}
	
	public static void main(String[] args) {
		isPermutationI p = new isPermutationI();
		System.out.println(p.isPermutation("A man, a plan, a canal: Panama"));
		System.out.println(p.isPermutation("race a car"));
		System.out.println(p.isPermutation("0P"));
	}
}
