
public class numberOfSegmentsInAString {
	
	// Time: O(n), Space: O(1);
	public int countSegments (String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
				count++;
		}
		return count;
		
		// s = s.trim();
		// if (s.length() == 0) return 0;
		// return s.split("\\s+").length;
	}
}
