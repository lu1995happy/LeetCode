import java.util.Arrays;

public class nextClosestTime {
	
	// Time : O(nlogn), Space: O(n);
	/* This approach here is trying to find next digit for each postion in “HH:MM” from right to left. 
	   If the next digit is greater than current digit, return directly and keep other digits unchanged.
	   Here is the steps: (e.g. "17:38")
	   Retrieve all four digits from given string and sort them in asscending order, "17:38" -> digits[] {'1', '3', '7', '8'}
	   Apply findNext() from the right most digit to left most digit, try to find next greater digit from digits[] (if exist)
   	   which is suitable for current position, otherwise return the minimum digit (digits[0]):
	  "HH:M_": there is no upperLimit for this position (0-9). Just pick the next different digit in the sequence. 
	   In the example above, '8' is already the greatest one, so we change it into the smallest one (digits[0] i.e. '1')
	   and move to next step: "17:38" -> "17:31"
	   "HH:_M": the upperLimit is '5' (00~59). The next different digit for '3' is '7', which is greater than '5', so 
	   we should omit it and try next. Similarly, '8' is beyond the limit, so we should choose next, 
	   i.e. '1': "17:38" -> "17:11"
	   "H_:MM": the upperLimit depends on result[0]. If result[0] == '2', then it should be no more than '3'; else no 
	   upperLimit (0-9). Here we have result[0] = '1', so we could choose any digit we want. The next digit for '7' is 
	   '8', so we change it and return the result directly. "17:38" -> "18:11"
	   "_H:MM": the upperLimit is '2' (00~23). e.g. "03:33" -> "00:00" 
	 */
	public String nextClosestTime (String time) {
		char[] res = time.toCharArray();
		char[] digits = new char[] {res[0], res[1], res[3], res[4]};
		Arrays.sort(digits);
		
		// find next digit for HH:M_
		res[4] = findNext (res[4], '9', digits); // no upperLimit for this digit, i.e. 0-9
		if (res[4] > time.charAt(4)) // e.g. 23:43 -> 23:44
			return String.valueOf(res);
		
		// find next digit for HH:_M
		res[3] = findNext (res[3], '5', digits);
		if (res[3] > time.charAt(3)) // e.g. 14:29 -> 14:41
			return String.valueOf(res);
		
		// find next digit for H_:MM
		res[1] = res[0] == '2' ? findNext (res[1], '3', digits) : findNext (res[1], '9', digits);
		if (res[1] > time.charAt(1)) // e.g. 02:37 -> 03:00 
			return String.valueOf(res);
		
		// find next digit for _H:MM
		res[0] = findNext (res[0], '2', digits);
		return String.valueOf(res); // e.g. 19:59 -> 11:11
	}
	
	/** 
     * find the next bigger digit which is no more than upperLimit. 
     * If no such digit exists in digits[], return the minimum one i.e. digits[0]
     * @param current the current digit
     * @param upperLimit the maximum possible value for current digit
     * @param digits[] the sorted digits array
     * @return 
     */
	public char findNext(char current, char upperLimit, char[] digits) {
		if (current == upperLimit)
			return digits[0];
		int pos = Arrays.binarySearch(digits, current) + 1;
		// traverse one by one to find next greater digit
		while (pos < 4 && (digits[pos] > upperLimit || digits[pos] == current))
			pos++;
		return pos == 4 ? digits[0] : digits[pos];
	}
}
