import java.util.Arrays;
import java.util.PriorityQueue;

public class meetingRoomsII {
	
	// Definition for an interval;
	public class Interval {
		int start;
		int end; 
		Interval() {
			start = 0;
			end = 0;
		}
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	// Time: O(nlogn), Space: O(n);
	public int minMeetingRooms (Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int res = 0, end = 0;
		for (int i = 0; i < intervals.length; i++) {
			if (starts[i] < ends[end]) {
				res++;
			} else {
				end++;
			}
		}
		return res;
	}
	
	// Time: O(nlogn), since poll() and offer() cost logn time, Space: O(n);
	public int minMeetingRooms2 (Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, (a, b) -> a.start - b.start);
		PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, (a, b) -> a.end - b.end);
		heap.offer(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			Interval curr = heap.poll();
			if (intervals[i].start >= curr.end) {
				curr.end = intervals[i].end;
			} else {
				heap.offer(curr);
			}
			heap.offer(intervals[i]);
		}
		return heap.size();
	}
}
