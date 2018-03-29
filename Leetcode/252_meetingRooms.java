import java.util.Arrays;
import java.util.Comparator;

public class meetingRooms {
	
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
	
	// Time: O(nlogn), Space: O(1);
	public boolean canAttendMeetings (Interval[] intervals) {
		if (intervals == null)
			return false;
		// Sort the intervals by start time
		// Arrays.sort(intervals, (a, b) -> a.start - b.start);
		Arrays.sort(intervals, new Comparator<Interval>() {
		    public int compare(Interval a, Interval b) { 
		    		return a.start - b.start; 
		    	}
		  });
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < intervals[i - 1].end) {
				return false;
			}
		}
		return true;
	}
	
	// another way to detect the result while sorting;
	private boolean canAttendMeetings2(Interval[] intervals) {
		try {
			Arrays.sort(intervals, new IntervalComparator());
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start < o2.start && o1.end <= o2.start)
				return -1;
			else if (o1.start > o2.start && o1.start >= o2.end)
				return 1;
			throw new RuntimeException();
		}
	}

}
