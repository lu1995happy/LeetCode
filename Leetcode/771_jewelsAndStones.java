
public class jewelsAndStones {
	public int numJewelInStones(String J, String S) {
		int count = 0;
		for (char ch : S.toCharArray()) {
			if (J.contains(String.valueOf(ch))) 
				count++;
		}
		return count;
	}
}
