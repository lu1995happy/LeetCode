
public class bestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices == null)
			return 0;
		int min = prices[0], max = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] > min) 
				max = Math.max(max, prices[i] - min);
			else 
				min = prices[i];
		}
		return max;
	}
	
	//Kadane's Algorithm
	public int maxProfitSoFar(int[] prices) {
		int maxCurr = 0, maxSoFar = 0;
		for (int i = 1; i < prices.length; i++) {
			maxCurr = Math.max(0, maxCurr += prices[i] - prices[i - 1]);
			maxSoFar = Math.max(maxSoFar, maxCurr);
		}
		return maxSoFar;
	}
}
