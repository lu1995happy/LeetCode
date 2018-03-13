
public class excelSheetColumnNumber {
	
	// Time: O(n), Space: O(1);
	public int titleToNumber(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum = sum * 26 + s.charAt(i) - 'A' + 1;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		excelSheetColumnNumber test = new excelSheetColumnNumber ();
		System.out.println(test.titleToNumber("ZA"));
	}
}
