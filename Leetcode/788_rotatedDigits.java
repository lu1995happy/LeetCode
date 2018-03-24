
public class rotatedDigits {
	
	// Time: O(n), Space: O(1);
	public int rotatedDigits (int n) {
		if (n < 2)
			return 0;
		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (isGood(i))
				count++;
			 i += incrementIfNeeded(i);
		}
		return count;
	}
	
	// optimize : skip all the values that leading by 3, 4 and 7; 
	public int incrementIfNeeded(int i) {
        int inc = 1;
        while (i >= 10) {
            inc *= 10;
            i /= 10;
        }
        if (i == 3 || i == 4 || i == 7) return inc - 1;
        else return 0;
    }
	
	public boolean isGood (int n) {
		/*
        Valid if N contains ATLEAST ONE 2, 5, 6, 9
        AND NO 3, 4 or 7s
        */
		boolean isGood = false;
		while (n != 0) {
			if (n % 10 == 3 || n % 10 == 4 || n % 10 == 7)
				return false;
			else if (n % 10 == 2 || n % 10 == 5 || n % 10 == 6 || n % 10 == 9)
				isGood = true;
			n /= 10;
		}
		return isGood;
	}
}
