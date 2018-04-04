
public class searchA2DMatrix {
	
	// Time: O(log(n * m)), Space: O(1);
	public boolean searchMatrix (int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int row = matrix.length, col = matrix[0].length;
		int start = 0, end = row * col - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (matrix[mid / col][mid % col] == target) {
				return true;
			} else if (matrix[mid / col][mid % col] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}
	
	public boolean searchMatrix2 (int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[] nums = new int[m * n];
		int index = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				nums[index] = matrix[i][j];
				index++;
			}
		}
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return true;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}
}
