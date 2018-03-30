
public class designCompressedStringIterator {
	
	String s;
	int index;
	Character cur;
	int count;
	
	// Time: O(n), Space: O(n);
	public designCompressedStringIterator (String compressedString) {
		this.s = compressedString;
		this.index = 0;
		this.cur = null;
		this.count = 0;
	}
	
	public char next() {
		if (count == 0) {
			if (index >= s.length()) {
				return ' ';
			}
			cur = s.charAt(index++);
			while (index < s.length() && Character.isDigit(s.charAt(index))) {
				count = count * 10 + Character.getNumericValue(s.charAt(index));
				index++;
			}
		}
		count--;
		return cur;
	}
	
	public boolean hasNext() {
		return index < s.length() || count != 0;
	}
	
}