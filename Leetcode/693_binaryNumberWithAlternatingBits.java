
public class binaryNumberWithAlternatingBits {
	
	public boolean hasBits(int n) {
		
		if (n <= 0) 
			return false;
		if (n == 1)
			return true;
		
		int tmp = n % 2;
		n /= 2;
		
		while (n != 0) {
			if (tmp == n % 2)
				return false;
			tmp = n % 2;
			n /= 2;
		}
		return true;
	}
	
	public boolean hasAlternatingBits(int n) {
		String res = convertToBinary(n);
		if (res.length() < 2)
			return true;
		
		for (int i = 1; i < res.length(); i++) {
			if (res.charAt(i) == res.charAt(i - 1))
				return false;
		}
		return true;
	}
	public String convertToBinary(int num) {
		StringBuilder sb = new StringBuilder();
		while (num > 1) {
			sb.append(num % 2);
			num /= 2;
		}
		sb.append("1");
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		binaryNumberWithAlternatingBits test = new binaryNumberWithAlternatingBits();
		System.out.println(test.hasAlternatingBits(5));
	}
}
