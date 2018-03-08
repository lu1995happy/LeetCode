import java.util.List;
import java.util.ArrayList;

public class fizzBuzz {
	public List<String> fizzBuzz (int n) {
		
		List<String> res = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) 
				res.add("FizzBuzz");
			else if (i % 5 == 0)
				res.add("Buzz");
			else if (i % 3 == 0)
				res.add("Fizz");
			else res.add(String.valueOf(i));
		}
		return res;
	}
	
	// not using % operation;
	public List<String> fizzBuzz1 (int n) {
		
		List<String> res = new ArrayList<String>();
		int fizz = 0;
		int buzz = 0;
		for (int i = 1; i <= n; i++) {
			fizz++;
			buzz++;
			if (fizz == 3 && buzz == 5) {
				res.add("FizzBuzz");
				fizz = 0;
				buzz = 0;
			}
			else if (fizz == 3) {
				res.add("Fizz");
				fizz = 0;
			}
			else if (buzz == 5) {
				res.add("Buzz");
				buzz = 0;
			}
			else 
				res.add(String.valueOf(i));	
		}
		return res;
	}
	
	public static void main(String[] args) {
		fizzBuzz test = new fizzBuzz();
		System.out.println(test.fizzBuzz(15));
	}
}
