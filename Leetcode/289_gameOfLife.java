
public class gameOfLife {
	
	// Time: O(m * n), Space: O(1);
	public void gameOfLife (int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return;
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int count = countNeighbor(board, i, j);
				if (board[i][j] == 1) {
					if (count == 2 || count == 3) {
						board[i][j] += 2;
					}
				} else if (count == 3) {
					board[i][j] += 2;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = board[i][j] >> 1;
			}
		}
	}
	
	public int countNeighbor(int[][] board, int i, int j) {
		int count = 0;
		for (int row = Math.max(0, i - 1); row <= Math.min(board.length - 1, i + 1); row++) {
			for (int col = Math.max(0, j - 1); col <= Math.min(board[0].length - 1, j + 1); col++) {
				count += board[row][col] & 1;
			}
		}
		count -= board[i][j] & 1;
		return count;
	}
}
