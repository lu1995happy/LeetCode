
public class multiplyStrings {
	public static String isMultiplyStrings(String num1, String num2) {
		int n = num1.length();
		int m = num2.length();
		int sum = 0;
		int mul = 0;
		int[] res = new int[n+m];
		if (num1 == null || num2 == null || n == 0 || m == 0) {
			return "";
		}
		if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = n-1; i >= 0; i--) {
			for (int j = m-1; j >= 0; j--) {
				mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j;
				int p2 = i + j + 1;
				sum = mul + res[p2];
				res[p1] += sum / 10;
				res[p2] = sum % 10;
			}
		}
		for (int p : res) {
			if (!(p == 0 & sb.length() == 0)) {
				sb.append(p);
			}
		}
		if (sb.length() == 0) {
			return "0";
		} else {
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isMultiplyStrings("2", "3"));
	}
}
