import java.util.Stack;

public class longestAbsoluteFilePath {
	
	// Time: O(n), Space: O(n);
	// "\n" and "\t" just count length as 1, example: s = "\tdir", length = 4; s.charAt(0) = null, s.charAt(2) == d;
	public int lengthLongestPath (String input) {
		
		if (input == null || input.length() == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		stack.push(0); // dummy length
		for (String s: input.split("\n")) {
			/*
            level is the number of "\t", level = 0 
            when "\t" is not found, because s.lastIndexOf("\t") returns -1.
            So normally, the first parent "dir" have level 0.
            */
			int level = s.lastIndexOf("\t") + 1; // number of "\t"
			/*
            The following part of code is the case that we want to consider when there are
            several sub-directories in a same level. We want to remove
            the path length of the directory or the file of same level
            that we added during previous step, and calculate 
            the path length of current directory or file that we are currently looking at.
            */
			while (level + 1 < stack.size()) { // find parent
				stack.pop();
			}
			int len = stack.peek() + s.length() - level + 1; // remove "\t", add "\"
			stack.push(len);
			// Only update the maxLen when a file is discovered, 
            // And remove the "/" at the end of file
			if (s.contains(".")) 
				res = Math.max(res, len - 1);
		}
		return res;
	}
}
