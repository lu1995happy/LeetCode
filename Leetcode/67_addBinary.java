
public class addBinary {
	public String addBinary(String a, String b) {
		
		// test base case
		if (a == null || b == null) 
			return a == null ? b : a;
		
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		// store the carry for the calculation
		int carry = 0;
		
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0)
				sum += a.charAt(i--) - '0';
			if (j >= 0)
				sum += b.charAt(j--) - '0';
			// add the number
			sb.append(sum % 2);
			// update the carry
			carry = sum / 2;
		}
		
		// don't forget the carry at the end
		if (carry != 0)
			sb.append(carry);
		
		// reverse return the string
		return sb.reverse().toString();
	}
}
