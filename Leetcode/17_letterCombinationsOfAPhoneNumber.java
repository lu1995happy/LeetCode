import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class letterCombinationsOfAPhoneNumber {
	
	// Time: O(3^n), Space: O(n);
	// iterative BFS
	// For each digit added, remove and copy every element in the queue and add the possible letter to each element, 
	// then add the updated elements back into queue again. Repeat this procedure until all the digits are iterated.
	public List<String> letterCombinations (String digits) {
		
		LinkedList<String> res = new LinkedList<>();
		
		if (digits == null || digits.length() == 0)
			return res;
		
		String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		res.add("");
		for (int i = 0; i < digits.length(); i++) {
			int num = Character.getNumericValue(digits.charAt(i));
			while (res.peek().length() == i) {
				String str = res.remove();
				for (char ch : map[num].toCharArray()) 
					res.add(str + ch);
			}
		}
		return res;
	}
	
	// backtracking
	public List<String> letterCombinations2 (String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return res;
		helper(res, digits, "", 0);
		return res;
	}
	
	public void helper(List<String> res, String digits, String s, int index) {
		String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		if (index == digits.length()) {
			res.add(s);
			return;
		}
		String letters = map[digits.charAt(index) - '0'];
		for (int i = 0; i < letters.length(); i++) {
			helper(res, digits, s + letters.charAt(i), index + 1);
		}
	}
}
