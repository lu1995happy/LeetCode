import java.util.TreeSet;

public class findGroup {
	public int findLastDay(int[] flower, int k, int m) {
		int n = flower.length;
		TreeSet<Integer> set = new TreeSet<>();
		set.add(0);
		set.add(n+1);
		int group = 0;
		int prevLow = 0;
		int prevHigh = n + 1;
		for (int i = n - 1; i >= 0; i--) {
			set.add(flower[i]);
			int low = set.lower(flower[i]);
			int high = set.higher(flower[i]);
			int left = flower[i] - set.lower(flower[i]) - 1;
			int right = set.higher(flower[i]) - flower[i] - 1;
			if (i == n - 1 && left >= k) {
				group++;
			}
			if (i == n - 1 && right >= k) {
				group++;
			}
			if (i != n - 1 && low != prevLow && left >= k) {
				group++;
				prevLow = low;
			}
			if (i != n - 1 && high != prevHigh && right >= k) {
				group++;
				prevHigh = high;
			}
			if (group == m) {
				return i;
			}
		}
		return -1;
	} 
	
	public static void main(String[] args) {
		findGroup test = new findGroup();
		int[] input = {1,4,3,2,5};
		System.out.println(test.findLastDay(input, 1, 3));
	} 
}
