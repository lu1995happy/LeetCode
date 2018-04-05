import java.util.ArrayList;
import java.util.List;

public class wordSearchII {
	
	// Intuitively, start from every cell and try to build a word in the dictionary. Backtracking (dfs) is the powerful 
	// way to exhaust every possible ways. Apparently, we need to do pruning when current character is not in any word.

	// How do we instantly know the current character is invalid? HashMap?
	// How do we instantly know what’s the next valid character? LinkedList?
	// But the next character can be chosen from a list of characters. "Mutil-LinkedList"?
	// Combing them, Trie is the natural choice. Notice that:

	// TrieNode is all we need. search and startsWith are useless.
	// No need to store character at TrieNode. c.next[i] != null is enough.
	// Never use c1 + c2 + c3. Use StringBuilder.
	// No need to use O(n^2) extra space visited[m][n].
	// No need to use StringBuilder. Storing word itself at leaf node is enough.
	// No need to use HashSet to de-duplicate. Use “one time search” trie.
	class TireNode {
		TireNode[] next = new TireNode[26];
		String word;
	}
	
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		if (board == null || board.length == 0 || board[0].length == 0) {
			return res;
		}
		TireNode root = buildTire(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, root, res);
			}
		}
		return res;
	}
	
	public void dfs (char[][] board, int i, int j, TireNode root, List<String> res) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return;
		}
		char cur = board[i][j];
		if (cur == '*' || root.next[cur - 'a'] == null) {
			return;
		}
		root = root.next[cur - 'a'];
		if (root.word != null) { // found one
			res.add(root.word);
			root.word = null; // remove duplicate
		}
		board[i][j] = '*';
		dfs(board, i - 1, j, root, res);
		dfs(board, i + 1, j, root, res);
		dfs(board, i, j - 1, root, res);
		dfs(board, i, j + 1, root, res);
		board[i][j] = cur; 
	}
	
	public TireNode buildTire (String[] words) {
		TireNode root = new TireNode();
		for (String word : words) {
			TireNode p = root;
			for (char ch : word.toCharArray()) {
				int i = ch - 'a';
				if (p.next[i] == null) {
					p.next[i] = new TireNode();
				}
				p = p.next[i];
			}
			p.word = word;
		}
		return root;
	}
}
