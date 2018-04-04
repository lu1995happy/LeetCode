import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {
	
	// Time: O(n^2), Space: O(n);
	public boolean wordBreak (String s, List<String> wordDict) {
		// dp[i] represents if s.substring(0, i) is wordbreakable;
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				// check with interviewer if contains treat as O(n) time or not;
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
	
	// optimized solution
	// Time: O(n), Space: O(n);
    public boolean wordBreak2(String s, List<String> wordDict) {
    		// record the maxLength for the words for the optimization
        int maxWordLen = 0;
        // using HashSet to avoid using list.contains() function;
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
            maxWordLen = Math.max(maxWordLen, word.length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
        		// optimization
            for (int j = i - 1; j >= 0 && i - j <= maxWordLen; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }        
        return dp[s.length()];
    }
}
