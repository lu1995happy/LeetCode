
public class repeatedSubstringPattern {
	
	// Using KMP
	// Time: O(n), Space: O(n);
	// In fact we only need to compute the pattern table (the lps array, see below) in the Knuth-Morris-Pratt algorithm.
	// The entry lps[i] is the length of the longest proper prefix that is also a suffix of (s[0], …, s[i]), or 
	// equivalently, length of the longest prefix that is also a proper suffix of (s[0], …, s[i]). lps[0] is 0, since a 
	// single - character string has no proper prefix or proper suffix. 
	// After we get lps, we relate the property of the lps table to the property of a string being constructed by joining 
	// copies of its substring.
	// One on hand, if str = (s[0], …, s[km - 1]) is constructed by joining m copies of its substring 
	// substr = (s[0], …, s[k-1]), and assuming that substr is the finest making blockstr can be boiled down to, meaning 
	// str is not constructed by joining copies of any proper substring of substr. Then we must have lps[km - 1] 
	// equals (m - 1)k.
	// On the other hand, assuming that the longest proper prefix of string str that is also a suffix, and the remaining 
	// string remainderStr obtained by removing prefix from str satisfies the following 3 properties:
	// 1. remainderStr is a proper substring of str,
	// 2. |str| is divisible by |remainderStr|,
	// 3. remainderStr is a prefix of prefixStr.
	// We can show by induction that str is constructed by joining copies of remainderStr.
    public boolean repeatedSubstringPattern(String str) {
        int l = str.length();
        int[] lps = new int[l];
        int leading = 1;
        int chasing = 0;
        while(leading < l) {
            if(str.charAt(chasing) == str.charAt(leading)) {
                chasing++;
                lps[leading] = chasing;
                leading++;
            }else {
                if(chasing > 0) {
                    chasing = lps[chasing - 1];
                }else {
                    chasing = 0;
                    leading++;
                }
            }
        }
        int lp = lps[l - 1];
        return (lp > 0 && l % (l - lp) == 0 && str.startsWith(str.substring(lp)));
    }
	
	// The length of the repeating substring must be a divisor of the length of the input string
	// Search for all possible divisor of str.length, starting for length/2
	// If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
	// If the repeated substring is equals to the input str return true
    public boolean repeatedSubstringPattern2(String str) {
        int l = str.length();
        for(int i = l / 2; i > 0; i--) {
            if(l % i == 0) {
                String substr = str.substring(0, i);
                int j = i;
                while(j < l) {
                    if(!str.substring(j, j + i).equals(substr)){
                        break;
                    }else {
                        j += i;
                    }
                }
                if(j == l) {
                    return true;
                }
            }
        }
        return false;
    }
    
	// First char of input string is first char of repeated substring
	// Last char of input string is last char of repeated substring
	// Let S1 = S + S (where S in input string)
	// Remove 1 and last char of S1. Let this be S2
	// If S exists in S2 then return true else false
	// Let i be index in S2 where S starts then repeated substring length i + 1 and repeated substring S[0: i+1]
	public boolean repeatedSubstringPattern4 (String s) {
		String str = s + s;
		return str.substring(1, str.length() - 1).contains(s);
	}
	
}
