
public class lengthOfLastWord {
	public int wordLength(String s) {
		
	//  Solution 1:
	//	String[] result = s.split("\\s+");
		
	//	if (result.length == 0) 
	//		return 0;
	//	else 
	//		return result[result.length - 1].length();
		
	//  Solution 2:	
	//	s = s.trim();
	//	int index = s.lastIndexOf(' ') + 1;
	//	return s.length() - index;
		
	// Solution 3:
		int length = 0;
		int tail = s.length() - 1;
		for (int i = tail; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				tail = i;
				break;
			}
		}
		for (int i = tail; i >= 0; i--) {
			if (s.charAt(i) != ' ')
				length++;
			else 
				break;
		}
		return length;	
	}

	
	public static void main(String[] args) {
		lengthOfLastWord test = new lengthOfLastWord();
		System.out.println(test.wordLength("Hello World"));
		System.out.println(test.wordLength("Hello World "));
		System.out.println(test.wordLength(""));
	}
}
