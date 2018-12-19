import java.util.TreeSet;

public class theLastDay {
	public int findLastDay(int[] flower, int k) {
		int n = flower.length;
		TreeSet<Integer> set = new TreeSet<>();
		set.add(0);
		set.add(n+1);
		for (int i = n - 1; i >= 0; i--) {
			set.add(flower[i]);
			int left = flower[i] - set.lower(flower[i]) - 1;
			int right = set.higher(flower[i]) - flower[i] - 1;
			if (left == k || right == k) {
				return i;
			}
		}
		return -1;
	} 
	
	public static void main(String[] args) {
		theLastDay test = new theLastDay();
		int[] input = {3,1,5,4,2};
		System.out.println(test.findLastDay(input, 2));
	}
}
