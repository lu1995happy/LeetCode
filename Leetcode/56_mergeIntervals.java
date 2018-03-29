import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class mergeIntervals {
	
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
	// The idea is to sort the intervals by their starting points. Then, we take the first interval and compare its end with 
	// the next intervals starts. As long as they overlap, we update the end to be the max end of the overlapping intervals.
	// Once we find a non overlapping interval, we can add the previous “extended” interval and start over.
	public List<Interval> merge (List<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1)
			return intervals;
		List<Interval> res = new ArrayList<>();
		// Sort by ascending starting point using an anonymous Comparator
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (Interval interval : intervals) {
			// Overlapping intervals, move the end if needed
			if (interval.start <= end) {
				end = Math.max(end, interval.end);
			} else { // Disjoint intervals, add the previous one and reset bounds
				res.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		// Add the last interval
		res.add(new Interval(start, end));
		return res;
	}
	
	// Time: O(nlogn), Space: O(1) : In place;
    public List<Interval> merge2(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1)   
        		return intervals;     
        // Collections.sort(intervals, (a, b) -> a.start - b.start);
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start == b.start)     
                		return b.end - a.end;
                return a.start - b.start;
            }
        });
        int i = 0;
        while (i < intervals.size() - 1) {
            Interval a = intervals.get(i), b = intervals.get(i + 1);
            if (a.end >= b.start) {
                a.end = Math.max(a.end, b.end);
                intervals.remove(i + 1);
            }
            else    i++;
        }
        return intervals;
    }
}
