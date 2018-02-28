public class detectCapital {
	public boolean detectCapitalUse(String word) {
		if (word.length() == 1) {
			return true;
		}
		return lowerCase(word) || upperCase(word) || comboCase(word);
	}
	
	public boolean lowerCase (String word) {
		for (char ch : word.toCharArray()) {
			if (!Character.isLowerCase(ch)) 
				return false;
		}
		return true;
	}
	
	public boolean upperCase (String word) {
		for (char ch : word.toCharArray()) {
			if (!Character.isUpperCase(ch)) 
				return false;
		}
		return true;
	}
	
	public boolean comboCase (String word) {
		if (Character.isUpperCase(word.charAt(0))) {
			for (int i = 1; i < word.length(); i++) {
				if (!Character.isLowerCase(word.charAt(i))) 
					return false;
			}
			return true;
		}
		return false;
	}
	
	public boolean isDetectCapitalUse(String word) {
	    int cnt = 0;
	    // Count capital letters.
	    for(char c: word.toCharArray()) 
	    		if('Z' - c >= 0) // Character.isLowerCase()
	    			cnt++;
	    // 3 cases:
	    // 1. There is no capital letters.
	    // 2. There are all capital letters.
	    // 3. if there is only 1 captial letter we check if only First character is captial not any other.
	    return ((cnt==0 || cnt==word.length()) || (cnt==1 && 'Z' - word.charAt(0)>=0));
	    //return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
	}
	
	public static void main(String[] args) {
		detectCapital dc = new detectCapital();
		System.out.println(dc.detectCapitalUse("BaaaaB"));
		System.out.println(dc.detectCapitalUse("aaaaaB"));
	}
}
