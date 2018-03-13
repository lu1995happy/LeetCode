
public class excelSheetcolumnTitle {
	
	// Time: O(n), Space: O(n);
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;
			sb.append((char)('A' + n % 26));
			n /= 26;
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		excelSheetcolumnTitle test = new excelSheetcolumnTitle();
		System.out.println(test.convertToTitle(29));
	}
}
