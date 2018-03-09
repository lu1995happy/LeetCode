
public class zigZagConversion {
	
	// Time: O(n), Space: O(n);
	public String convert(String s, int numRows) {
		
		if (numRows <= 1)
			return s;
		
		int index = 0;
		
		//initialize the StringBuilder
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < sb.length; i++) 
			sb[i] = new StringBuilder("");
		
		// find the right place to put the character
		// follow 2 * numRows - 2
		for (int i = 0; i < s.length(); i++) {
			index = i % (2 * numRows - 2);
			index = index < numRows ? index : 2 * numRows - 2 - index;
			sb[index].append(s.charAt(i));
		}
		
		// convert to one string
		for (int i = 1; i < sb.length; i++)
			sb[0].append(sb[i]);
		
		return sb[0].toString();
	}
}
