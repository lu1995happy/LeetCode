
public class plusOne {
	public int[] isPlusOne(int[] digits) {
		int length = digits.length;
		
		// if the number is less than 9; 
		// just plus one at the digit and return the number;
		for (int i = length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		// this case is only for the whole number is full of 9's;
		// example: 999999999;
		int[] res = new int[length + 1];
		res[0] = 1;
		return res;
	}
}
