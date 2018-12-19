import java.util.HashSet;
import java.util.Set;

public class nextClosestTimePermutation {
	public Set<String> getAllPermutations(String s) {
		Set<String> permutations = new HashSet<String>();
		if (s == null || s.length() == 0) {
			permutations.add("");
			return permutations;
		}
		char firstChar = s.charAt(0);
		String remain = s.substring(1);
		Set<String> words = getAllPermutations(remain);
		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) {
				String prefix = word.substring(0, i);
				String suffix = word.substring(i);
				permutations.add(prefix + firstChar + suffix);
			}
		}
		return permutations;
	}
	
	public int stringToTime(String s) {
		int hrs = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
		int mins = (s.charAt(2) - '0') * 10 + (s.charAt(3) - '0');
		return hrs * 60 + mins;
	}
	
	public boolean checkValid(String s) {
		int hrs = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
		int mins = (s.charAt(2) - '0') * 10 + (s.charAt(3) - '0');
		boolean valid = false;
		if (hrs < 24 && mins < 60) {
			valid = true;
		}
		return valid;
	}
	
	public String findClosestTime(String s) {
		String target = s.substring(0, 2) + s.substring(3);
		int curr = stringToTime(target);
		int minDiff = 24 * 60;
		int res = curr;
		Set<String> words = getAllPermutations(target);
		for (String word : words) {
			if (checkValid(word)) {
				int num = stringToTime(word);
				int diff = num - curr;
				if (diff < 0) {
					diff = 24 * 60 - curr + num;
				}
				if (diff < minDiff && diff > 0) {
					minDiff = diff;
					res = num;
				}
			}
		}
		return String.format("%02d:%02d", res / 60, res % 60);
 	}
	
	public static void main(String[] args) {
		nextClosestTimePermutation test = new nextClosestTimePermutation();
		System.out.println(test.findClosestTime("23:59"));
		System.out.println(test.findClosestTime("11:21"));
	    System.out.println(test.findClosestTime("18:00"));
	    System.out.println(test.findClosestTime("24:00"));
	    System.out.println(test.findClosestTime("09:30"));
	    System.out.println(test.findClosestTime("13:24"));
	    System.out.println(test.findClosestTime("23:56"));
	    System.out.println(test.findClosestTime("11:11"));
	    System.out.println(test.findClosestTime("03:24"));
	    System.out.println(test.findClosestTime("18:37"));
	    System.out.println(test.findClosestTime("17:38"));
	    System.out.println(test.findClosestTime("11:00"));
	}
}
