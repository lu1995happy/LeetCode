
public class palindromePermutation {
	
	// Time: O(n), Space: O(1);
    // or use a HashSet, remove the char if it contains in the set
    // return set.size <= 1;
	public boolean canPermutePalindrome (String s) {
		char[] count = new char[256];
		for (char ch : s.toCharArray()) {
			count[ch]++;
		}
		boolean odd = false;
		for (int num : count) {
			if (num % 2 == 1) {
				if (odd)
					return false;
				else 
					odd = true;
			}
		}
		return true;
	}
}
