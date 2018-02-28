public class isPalindromePermutation {
	//Character.getNumericValue(char) can ignore case sensitive
	//can be used to define letter numbers
	//Time:O(n); Space:O(1);
	public boolean checkPalindromePermutaion(String s) {
		int odd = 0;
		int[] count = new int[128];
		for (char ch: s.toCharArray()) {
			if (getCharNumber(ch) != -1) {
				count[getCharNumber(ch)] ++;
				if (count[getCharNumber(ch)] % 2 == 1) {
					odd++;
				} else {
					odd--;
				}
			}
		}
		return odd <= 1;
	}
	
	public int getCharNumber(char ch) {
		int a = Character.getNumericValue('a');
		int b = Character.getNumericValue('z');
		int c = Character.getNumericValue(ch);
		if (c >= a & c <= b) {
			return c;
		}
		return -1;	
	}
	
	public static void main(String[] args) {
		isPalindromePermutation k = new isPalindromePermutation();
		System.out.println(k.checkPalindromePermutaion("tackcat"));
		System.out.println(k.checkPalindromePermutaion("tack cat"));
		System.out.println(k.checkPalindromePermutaion("sdfaR@#R@#R@#124123rAFD"));
		System.out.println(Character.getNumericValue('Z'));
		System.out.println(Character.getNumericValue('z'));
	}
}
