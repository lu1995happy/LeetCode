import java.util.Arrays;

public class nextGreaterElementIII {
	//At first, lets look at the edge cases -
	//If all digits sorted in descending order, then output is always “Not Possible”. For example, 4321.
	//If all digits are sorted in ascending order, then we need to swap last two digits. 
	//For example, 1234. For other cases, we need to process the number from rightmost side 
	//(why? because we need to find the smallest of all greater numbers)
	
	//Now the main algorithm works in following steps -
	
	//I) Traverse the given number from rightmost digit, keep traversing till you find a digit which is 
	//smaller than the previously traversed digit. For example, if the input number is “534976”, we stop
	//at 4 because 4 is smaller than next digit 9. If we do not find such a digit, 
	//then output is “Not Possible”.

	//II) Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’. 
	//For “534976″, the right side of 4 contains “976”. The smallest digit greater than 4 is 6.

	//III) Swap the above found two digits, we get 536974 in above example.

	//IV) Now sort all digits from position next to ‘d’ to the end of number. The number that we get 
	//after sorting is the output. For above example, we sort digits in bold 536974. We get “536479” 
	//which is the next greater number for input 534976.
	public int nextGreaterElement(int n) {
		
		char[] ch = String.valueOf(n).toCharArray();
		int length = ch.length - 1;
		int i = 0;
		
		// I) Start from the right most digit and 
        // find the first digit that is
        // smaller than the digit next to it.
		for (i = length; i > 0; i--) {
			if (ch[i] > ch[i-1])
				break;
		}
		
		// If no such digit is found, its the edge case 1.
		if (i == 0)
			return -1;
		
		// II) Find the smallest digit on right side of (i-1)'th 
        // digit that is greater than number[i-1]
		int smallest = i;
		int index = ch[i - 1];
		for (int j = i + 1; j < ch.length; j++) {
			if (ch[j] <= ch[smallest] && ch[j] > index) 
				smallest = j;
		}
		
		// III) Swap the above found smallest digit with 
        // number[i-1]
		char tmp = ch[smallest];
		ch[smallest] = ch[i - 1];
		ch[i - 1] = tmp;
		
		// IV) Sort the digits after (i-1) in ascending order
		Arrays.sort(ch, i, ch.length);
		
		long result = Long.parseLong(new String(ch));
		return (result <= Integer.MAX_VALUE) ? (int)result : -1;
	}
	
	public int nextGreaterElements(int n) {
		
        if(n <= 0) return -1;
        
        char[] digit = (n + "").toCharArray();
        int num = digit.length;

        for(int i = num - 2; i >= 0; i--){
            if(digit[i] >= digit[i + 1]) 
            		continue;
            for(int j = num - 1; j > i; j--){
                if(digit[j] > digit[i]) {
                    swap(digit, i, j);
                    reverse(digit, i + 1);
                    try{
                        return Integer.parseInt(String.valueOf(digit));
                    }
                    catch(Exception e){
                        return -1;
                    }    
                }
            }
        }
        return -1;
        
    }
    
    
    private void swap(char[] digit, int s, int d){
        char tmp = digit[s];
        digit[s] = digit[d];
        digit[d] = tmp;
    }
    
    private void reverse(char[] digit, int s){
        int e = digit.length - 1;
        while(s < e){
            swap(digit, s, e);
            s++;
            e--;
        } 
    }
	
	public static void main(String[] args) {
		nextGreaterElementIII test = new nextGreaterElementIII();
		System.out.println(test.nextGreaterElement(1999999999));
	}
}
