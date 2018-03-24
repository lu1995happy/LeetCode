
public class reshapeTheMatrix {
	
	// Time: O(mn), Space: O(mn);
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		
		if (nums == null || nums.length == 0 || nums[0].length == 0 || r * c != nums.length * nums[0].length) 
			return nums;
		
		int[][] res = new int[r][c];
		
		int row = 0;
		int col = 0;
		
		// for (int i=0;i<r*c;i++) 
        // 		res[i/c][i%c] = nums[i/m][i%m];

		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				if (row < nums.length && col < nums[0].length)
					res[i][j] = nums[row][col];
				if (col < nums[0].length) {
					col++;
					if (col == nums[0].length) {
						col = 0;
						row++;
					}
				} 
			}
		}
		return res;
	}
}
