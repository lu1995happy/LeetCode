
public class addStrings {
	
	// Time: O(n + m), Space: O(n);
	public String addStrings (String num1, String num2) {
		
		if (num1 == null || num1.length() == 0)
			return num2;
		if (num2 == null || num2.length() == 0)
			return num1;
		
		StringBuilder sb = new StringBuilder();
		int carry = 0, sum = 0;
		int len1 = num1.length() - 1;
		int len2 = num2.length() - 1;
		
		// for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--)
		while (len1 >= 0 || len2 >= 0) {
			sum = carry;
			if (len1 >= 0) {
				sum += Character.getNumericValue(num1.charAt(len1)); // sum += num1.charAt(len1) - '0';
				len1--;
			}
			if (len2 >= 0) {
				sum += Character.getNumericValue(num2.charAt(len2));
				len2--;
			}
			sb.append(sum % 10);
			carry = sum / 10;
		}
		
		if (carry != 0)
			sb.append(carry);
		
		return sb.reverse().toString();
	}
}
