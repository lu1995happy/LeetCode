
public class searchA2DMatrixII {
	
	// Time: O(m + n), Space: O(1);
	public boolean searchMatrix (int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int row = 0, col = matrix[0].length - 1;
		while (row <= matrix.length - 1 && col >= 0) {
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				row++;
			} else {
				col--;
			}
		}
		return false;
	}
}
