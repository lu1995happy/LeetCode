import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class zigzagIterator {
	
	Iterator<Integer> i, j, temp;
	
	// Time: O(n), Space: O(1);
	public zigzagIterator (List<Integer> v1, List<Integer> v2) {
		i = v2.iterator();
		j = v1.iterator();
	}
	
	public int next() {
		if (j.hasNext()) {
			temp = i;
			i = j;
			j = temp;
		}
		return i.next();
	}
	
	public boolean hasNext() {
		return i.hasNext() || j.hasNext();
	}
	
	LinkedList<Iterator> list;
	// Queue<Iterator> queue;
	
	// Time: O(n), Space: O(2);
	public void zigzagIterator (List<Integer> v1, List<Integer> v2) {
		list = new LinkedList<>();
		// queue = new LinkedList<>();
		if (!v1.isEmpty())
			list.add(v1.iterator());
			// queue.offer(v1.iterator());
		if (!v2.isEmpty())
			list.add(v2.iterator());
			// queue.offer(v2.iterator());
	}
	
	public int next2() {
		Iterator poll = list.remove();
		// Iterator curr = queue.poll();
		int res = (Integer) poll.next();
		// int res = (int) curr.next();
		if (poll.hasNext())
			list.add(poll);
		return res;
	}
	
	public boolean hasNext2() {
		return !list.isEmpty();
		//return queue.peek() != null;
	}
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
