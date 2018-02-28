import java.util.HashSet;

public class intersectionOfTwoArrays {
	
	// Using two HashSet, Time complexity: O(n);
	// HashSet will ignore the duplicate numbers;
	
	public int[] intersection(int[] num1, int[] num2) {
		
		if (num1 == null || num2 == null || num1.length == 0 || num2.length == 0) {
			return new int[0];
		}
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> interset = new HashSet<>();
		for (int i = 0; i < num1.length; i++) {
			set.add(num1[i]);
		}
		for (int j = 0; j < num2.length; j++) {
			if (set.contains(num2[j])) {
				interset.add(num2[j]);
				set.remove(num2[j]);
			}
		}
		int[] result = new int[interset.size()];
		int i = 0;
		for (Integer num : interset) {
			result[i++] = num;
		}
		return result;
	}
}
