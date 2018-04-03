import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class queueReconstructionByHeight {
	
	// Time: O(n^2), Space: O(n);
	// pick up the tallest guy first
    // when insert the next tall guy, just need to insert him into kth position
    // repeat until all people are inserted into list
	public int[][] reconstructQueue (int[][] people) {
		if (people == null || people.length == 0 || people[0].length == 0)
			return people;
		List<int[]> res = new ArrayList<>(); 
		Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            }
        });
		for (int[] pos : people) {
			res.add(pos[1], pos);
		}
		return res.toArray(new int[people.length][2]);
	}
}
