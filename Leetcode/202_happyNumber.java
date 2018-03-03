import java.util.HashSet;
import java.util.Set;

public class happyNumber {
	
	// use HashSet to store the number that happens once in order to avoid cycling;
	// or use recursion to detect cycling; example: slow = isHappy(n); fast = isHappy(isHappy(n));
	// if slow = fast, return false;
	
	
    // space improvement
    // Unhappy numbers follow cycle -> 4, 16, 37, 58, 89, 145, 42, 20, 4...
	// just check if n == 1 return true; if n == 4 return false;
 
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while (set.add(n)) {
			int sum = 0;
			while (n > 0) {
				sum = sum + (n % 10) * (n % 10);
				n = n / 10;
			}
			if (sum == 1) 
				return true;
			else 
				n = sum;
		}
		return false;
	}
	
	public static void main(String[] args) {
		happyNumber test = new happyNumber();
		System.out.println(test.isHappy(19));
	}
}
