public class complexNumberMultiplication {
	
	// This solution relies on the fact that (a + bi)(c + di) = (ac - bd) + (ad + bc)i.
	public String complexNumberMultiply(String a, String b) {
		String[] str1 = a.split("\\+");
		String[] str2 = b.split("\\+");
		int a1 = Integer.parseInt(str1[0]);
		int b1 = Integer.parseInt(str1[1].replace("i", ""));
		int a2 = Integer.parseInt(str2[0]);
		int b2 = Integer.parseInt(str2[1].replace("i", ""));
		return (a1 * a2 - b1 * b2) + "+" + (a1 * b2 + a2 * b1 + "i");
    }
	
	public static void main(String[] args) {
		complexNumberMultiplication com = new complexNumberMultiplication();
		System.out.println(com.complexNumberMultiply("1+1i", "1+1i"));
	}
}
