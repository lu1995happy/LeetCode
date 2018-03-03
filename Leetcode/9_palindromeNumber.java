
public class palindromeNumber {
	// Time: O(n); Space: O(1);
	// doesn't consider overflow;
	public boolean isPalindrome(int num) {
		
		if (num < 0 || num != 0 && num % 10 == 0)
			return false;
		if (num < 10)
			return true;
		
		int res = 0;
		int number = num;
		
		while (number > 0) {
			res = res * 10 + number % 10;
			number = number / 10;
		}
		
	 //   Solution consider overflow:
	 //   while (number > res) {
	 //   	res = res * 10 + number % 10;
     //		number = number / 10;
	 //   }
	 //   return (number == res || number == res / 10);
		
		return num == res;	
	}
}
