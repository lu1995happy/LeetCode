
public class base7 {
	
	// iterative solution
	// Time: O(n), Space: O(n);
	public String convertToBase7 (int num) {
		if (num == 0)
			return "0";
		boolean negative = false;
		if (num < 0)
			negative = true;
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			sb.append(Math.abs(num % 7));
			num /= 7;
		}
		if (negative)
			sb.append("-");
		return sb.reverse().toString();
	}
	
	// recursion solution 
	// Time: O(n), Space: O(n);
	public String convertToBase72 (int num) {
		if (num < 0)
			return "-" + convertToBase72(-num);
		if (num < 7) 
			return num + "";
		return convertToBase72(num / 7) + num % 7;
	}
}
