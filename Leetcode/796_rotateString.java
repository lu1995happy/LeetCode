
public class rotateString {
	
	// Time: O(n), Space: O(1);
	public boolean rotateString (String A, String B) {
		
		if (A.length() != B.length())
			return false;
		String str = A + A;
		return str.contains(B);
		
		// return A.length() == B.length() && (A + A).contains(B);
	}
}
