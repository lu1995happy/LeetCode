import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class thirdMaximumNumber {
	public int thirdMax(int[] nums) {
		// PriorityQueue is in decreasing order
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Set<Integer> set = new HashSet<>();
		for (int num: nums) {
			if (!set.contains(num)) {
				// there's no difference between offer() and add() in PriorityQueue
				// add() is always return true and throw an exception if it can't add number
				// offer() is allowed to return false it it can't add number
				pq.add(num);
				set.add(num);
				if (pq.size() > 3) 
					set.remove(pq.poll());
			}
		}
		// if there's no 3rd maximum number, just return the largest number in the array
		if (pq.size() < 3) {
			while (pq.size() > 1)
				pq.poll();
		}
		return pq.peek();
	}
}
