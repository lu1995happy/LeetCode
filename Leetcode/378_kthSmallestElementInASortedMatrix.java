import java.util.PriorityQueue;

public class kthSmallestElementInASortedMatrix {
	
	// The key point for any binary search is to figure out the “Search Space”. For me, I think there are two kind 
	// of “Search Space” – index and range(the range from the smallest number to the biggest number). Most usually, when 
	// the array is sorted in one direction, we can use index as “search space”, when the array is unsorted and we are 
	// going to find a specific number, we can use “range”.
	public int kthSmallest(int[][] matrix, int k) {
		int low = matrix[0][0], high = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
		while(low < high) {
			int mid = low + (high - low) / 2;
	        int count = 0,  j = matrix[0].length - 1;
	        for(int i = 0; i < matrix.length; i++) {
	        		while (j >= 0 && matrix[i][j] > mid) 
	        			j--;
	                count += (j + 1);
	            }
	            if(count < k) 
	            		low = mid + 1;
	            else 
	            		high = mid;
	        }
	        return low;
	}
	
	class Tuple {
		int x, y, val;
		public Tuple(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
	// Build a minHeap of elements from the first row.
	// Do the following operations k-1 times :
	// Every time when you poll out the root(Top Element in Heap), you need to know the row number and column number of 
	// that element(so we can create a tuple class here), replace that root with the next element from the same column.
	public int kthSmallest2 (int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k == 0) {
			return -1;
		}
		PriorityQueue<Tuple> minHeap = new PriorityQueue<>(matrix.length, (a, b) -> (a.val - b.val));
		for (int i = 0; i < matrix.length; i++) {
			minHeap.offer(new Tuple(0, i, matrix[0][i]));
		}
		for (int i = 0; i < k - 1; i++) {
			Tuple tuple = minHeap.poll();
			if (tuple.x == matrix.length - 1) {
				continue;
			}
			minHeap.offer(new Tuple(tuple.x + 1, tuple.y, matrix[tuple.x + 1][tuple.y]));
		}
		return minHeap.peek().val;
	}
}
