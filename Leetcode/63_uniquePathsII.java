
public class uniquePathsII {
	
	// Time: O(m * n), Space: O(n);
	// Array res stores the number of paths which passing this point. The whole algorithm is to sum up the paths from 
	// left grid and up grid. 'if (row[j] == 1) res[j] = 0; means if there is an obstacle at this point. All the paths 
	// passing this point will no longer valid. In other words, the grid right of the obstacle can be reached only by 
	// the grid which lies up to it.
	public int uniquePathsWithObstacles (int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 0;
		}
		int width = obstacleGrid[0].length;
		int[] res = new int[width];
		res[0] = 1;
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < width; j++) {
				if (obstacleGrid[i][j] == 1) {
					res[j] = 0;
				} else {
                    if (j > 0) {
				    	res[j] += res[j - 1];
                    }
				}
			}
		}
		return res[width - 1];
	}
}
