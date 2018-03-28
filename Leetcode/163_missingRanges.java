import java.util.ArrayList;
import java.util.List;

public class missingRanges {
	
	// Time: O(n), Space: O(1);
	// use long to avoid overflow;
	public List<String> findMissingRanges (int[] nums, int lower, int upper) {
		
		List<String> res = new ArrayList<>(); 
		long aLower = (long) lower, aUpper = (long) upper;	
		for (int num : nums) {
			if (num == aLower) {
				aLower++;
			} else if (aLower < num) {
				if (aLower + 1 == num) 
					res.add(String.valueOf(aLower));
				else 
					res.add(aLower + "->" + (num - 1));
				aLower = (long) num + 1;
			}
		}
		if (aLower == aUpper)
			res.add(String.valueOf(aLower));
		else if (aLower < aUpper)
			res.add(aLower + "->" + aUpper);
		return res;		
	}
}
