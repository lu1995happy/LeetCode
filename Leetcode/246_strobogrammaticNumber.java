import java.util.HashMap;

public class strobogrammaticNumber {
	
	// Time: O(n), Space: O(n);
	public boolean isStrobogrammatic (String num) {
		if (num == null || num.length() == 0)
			return false;
		HashMap<Character, Character> map = new HashMap<>();
		map.put('6', '9');
		map.put('9', '6');
		map.put('1', '1');
		map.put('8', '8');
		map.put('0', '0');
		int left = 0, right = num.length() - 1;
		while (left <= right) {
			if (!map.containsKey(num.charAt(left)))
				return false;
			if (map.get(num.charAt(left)) != num.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
}
