/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   int guess(int num);
*/

public class guessNumberHigherOrLower {
	
	// binary search, Time: O(logn);
	public int guessNumber(int n) {
		if (guess(n) == 0)
			return n;
		int low = 1, high = n, mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (guess(mid) == 0) 
				break;
			else if (guess(mid) == -1)
				high = mid - 1;
			else 
				low = mid + 1;
		}
		return mid;
	}
	
	public int guess(int n) {
		return 0;
	}
}
