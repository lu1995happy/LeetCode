
public class rangeAddition {
	
	// Time: O(n + k), Space: O(n);
	public int[] getModifiedArray (int length, int[][] updates) {
		int[] res = new int[length];
		if (length == 0 || updates == null || updates.length == 0 || updates[0].length == 0)
			return res;
		for (int[] num : updates) {
			int start = num[0];
			int end = num[1];
			int value = num[2];
			res[start] += value;
			if (end < length) {
				res[end] -= value;
			}
		}
		int sum = 0;
		for (int i = 0; i < length; i++) {
			res[i] += sum;
			sum = res[i];
		}
		return res;
	}
}
