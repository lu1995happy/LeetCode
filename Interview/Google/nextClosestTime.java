import java.util.Arrays;

public class nextClosestTime {
	// 1: original  23:59 -> 22:22  19:34 -> 19: 39   13:14 -> 13:34
	
	// 2: next closest time after + no reuse (permutation) 23:59 -> 23:59  19:34 -> 19: 43
	
	// 3: next closest time before + reuse   23:59 -> 23:55    19:34 -> 19:33  13:14 -> 13:11   23:51 -> 23:35  19:51 -> 19:19  19:11 -> 11:19  
	
	// 4: next closest time before + no reuse (permutation)  23:59 -> 23:59    19:34 -> 14:39 
	
	public String nextClosestTimeBefore (String time) {
		char[] res = time.toCharArray();
		char[] digits = new char[] {res[0], res[1], res[3], res[4]};
		Arrays.sort(digits);
		
		if (digits[0] == digits[3]) {
			return time;
		}
		
		// find next digit for HH:M_
		res[4] = findNextSmaller (res[4], '9', digits); // no upperLimit for this digit, i.e. 0-9
		if (res[4] < time.charAt(4)) // e.g. 23:43 -> 23:44
			return String.valueOf(res);
		
		// find next digit for HH:_M
		res[3] = findNextSmaller (res[3], '5', digits);
		if (res[3] < time.charAt(3)) // e.g. 14:29 -> 14:41
			return String.valueOf(res);
		
		// find next digit for H_:MM
		res[1] = res[0] == '2' ? findNextSmaller (res[1], '3', digits) : findNextSmaller (res[1], '9', digits);
		if (res[1] < time.charAt(1)) // e.g. 02:37 -> 03:00 
			return String.valueOf(res);
		
		// find next digit for _H:MM
		res[0] = findNextSmaller (res[0], '2', digits);
		return String.valueOf(res); // e.g. 19:59 -> 11:11
	}
	
	public char findNextSmaller(char current, char upperLimit, char[] digits) {
		if (current == digits[0]) {
			if (digits[3] <= upperLimit) {
				return digits[3];
			} else {
				int pos = Arrays.binarySearch(digits, current) + 1;
				while (pos <= 2 && (digits[pos + 1] <= upperLimit)) {
					pos++;
				}
				return digits[pos];
			}		
		}
		int pos = Arrays.binarySearch(digits, current) - 1;
		// find next smaller digit
		return digits[pos];	
	}
	
	public String nextClosestTimePermutation (String time) {
		char[] res = time.toCharArray();
		char[] digits = new char[] {res[0], res[1], res[3], res[4]};
		int[] digit = new int[digits.length];
		for (int i = 0; i < digits.length; i++) {
			digit[i] = digits[i] - '0';
		}
		digit = nextPermutation(digit);
		String result = digit[0] + digit[1] + ":" + digit[2] + digit[3];
		return result;
	}
	
	
	public int[] nextPermutation (int[] nums) {
		if (nums == null || nums.length <= 1)
			return nums;
		// from back of the array, find the first element that is in increasing order;
		int firstSmall = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				firstSmall = i;
				break;
			}
		}
		// if not found, means that the array is in decreasing order, so just need to reverse the array;
		if (firstSmall == -1) {
			reverse(nums, 0, nums.length - 1);
            return nums;
		}
		// if found, then we need to find the first element that is large than the firstSmall, swap them;
		for (int i = nums.length - 1; i > firstSmall; i--) {
			if (nums[i] > nums[firstSmall]) {
				int temp = nums[firstSmall];
				nums[firstSmall] = nums[i];
				nums[i] = temp;
				break;
			}
		}
		// then we have to make the part that after firstSmall increasing order;
		reverse(nums, firstSmall + 1, nums.length - 1);
		return nums;
	}
	
	public void reverse (int[] nums, int i, int j) {
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;	
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		nextClosestTime time = new nextClosestTime();
		System.out.println(time.nextClosestTimeBefore("19:11"));
		System.out.println(time.nextClosestTimeBefore("23:59"));
		System.out.println(time.nextClosestTimeBefore("19:34"));
		System.out.println(time.nextClosestTimeBefore("23:51"));
		System.out.println(time.nextClosestTimeBefore("19:51"));
		System.out.println(time.nextClosestTimePermutation("19:11"));
		System.out.println(time.nextClosestTimePermutation("23:59"));
		System.out.println(time.nextClosestTimePermutation("19:34"));
		System.out.println(time.nextClosestTimePermutation("23:51"));
		System.out.println(time.nextClosestTimePermutation("19:51"));
	}
	
	

}
