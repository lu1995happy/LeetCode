
public class judgeRouteCircle {
	
	// Time: O(n), Space: O(1);
	public boolean judgeCircle (String moves) {
		if (moves == null || moves.length() <= 1 || moves.length() % 2 == 1)
			return false;
		int countUp = 0, countLeft = 0;
		for (char ch : moves.toCharArray()) {
			if (ch == 'U') {
				countUp++;
			} else if (ch == 'D') {
				countUp--;
			} else if (ch == 'L') {
				countLeft++;
			} else if (ch == 'R') {
				countLeft--;
			}
		}
		return countUp == 0 && countLeft == 0;
	}
}
