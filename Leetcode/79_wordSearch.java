
public class wordSearch {
	
	// Time: O((m * n) ^ 2), Space: O(m * n);
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}
		if (word == null || word.length() == 0) {
			return true;
		}
		char[] ch = word.toCharArray();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (exist(board, ch, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean exist(char[][] board, char[] ch, int i, int j, int start) {
		if (start == ch.length) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return false;
		}
		if (board[i][j] != ch[start]) {
			return false;
		} 
		char prev = board[i][j];
		board[i][j] = '*';
		start++;
		boolean exist = exist(board, ch, i + 1, j, start) || 
						exist(board, ch, i - 1, j, start) ||
						exist(board, ch, i, j - 1, start) ||
						exist(board, ch, i, j + 1, start);
		board[i][j] = prev;
		return exist;
	}
}
