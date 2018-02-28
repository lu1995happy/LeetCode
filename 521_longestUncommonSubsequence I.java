public class longestUncommonSubsequenceI {
	
	// Case 1: a=b. If both the strings are identical, it is obvious that no subsequence will be uncommon. Hence, return -1.
    // Case 2: length(a) = length(b) and a != b; Example: abcabc and abdabd. 
	// In this case we can consider any string i.e. abcabc or abdabd as a required subsequence;
	// as out of these two strings one string will never be a subsequence of other string. 
	// Hence: return length(a) or length(b).
	// Case 3: length(a) != length(b); Example abcdabcd and abcabc. 
	// In this case we can consider bigger string as a required subsequence because bigger string can't be a subsequence of smaller string.
	// Hence: return Max(length(a), length(b)).
	
	public static int isLongestUncommonSubsequenceI(String a, String b) {
		if (a.equals(b)) {
			return -1;
		}
		return Math.max(a.length(),b.length());
	}
	
	public static void main(String[] args) {
		System.out.println(isLongestUncommonSubsequenceI("abc","bca"));
		System.out.println(isLongestUncommonSubsequenceI("abcd","bca"));
		System.out.println(isLongestUncommonSubsequenceI("bca","bca"));
	}
}
