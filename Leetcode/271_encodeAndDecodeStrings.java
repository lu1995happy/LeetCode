import java.util.ArrayList;
import java.util.List;

public class encodeAndDecodeStrings {
	
	// Time: O(n), Space: O(n);
	// encode string : "ab", "cde" -> "2/ab3/cde"
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
        		sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
        		int slash = s.indexOf("/", i);
        		int size = Integer.valueOf(s.substring(i, slash));
        		res.add(s.substring(slash + 1, slash + size + 1));
        		i = slash + size + 1;
        }
        return res;
    }
 
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
