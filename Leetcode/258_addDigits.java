public class addDigits {
	
	// pure math problem;
	public int isAddDigits(int num) {
		
        // return 1 + (num - 1) % 9;
		while (num >= 10) {
			int sum = 0;
			while (num > 0) {
				sum += num % 10;
				num = num / 10;
			}
			num = sum;
		}
		return num; 
	}
	
	public static void main(String[] args) {
		addDigits test = new addDigits();
		System.out.println(test.isAddDigits(138));
	}
}
