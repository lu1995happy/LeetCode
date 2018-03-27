import java.util.LinkedList;
import java.util.Queue;

/*
 * Leetcode: 346
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */

public class movingAverageFromDataStream {
	
	Queue<Integer> queue;
	int len;
	int sum;
	
	// Time: O(1), Space: O(n);
	// or we can use int[] to solve the data; replace the val using the index = (index + 1) % size;
    /** Initialize your data structure here. */
    public movingAverageFromDataStream(int size) {
        len = size;
        sum = 0;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        if (queue.size() == len) 
        		sum -= queue.poll();
        queue.add(val);
        sum += val;
        return (double) sum / queue.size();
    }
    
    public static void main(String[] args) {
    		movingAverageFromDataStream test = new movingAverageFromDataStream(3);
    		System.out.println(test.next(1));
    		System.out.println(test.next(10));
    		System.out.println(test.next(3));
    		System.out.println(test.next(5));
    }
    
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
