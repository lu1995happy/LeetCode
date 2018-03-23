
public class islandPerimeter {
	
	// Java is considered "row major", meaning that it does rows first. This is because a 2D array is an "array of arrays".
	// int[ ][ ] a = new int[2][4];  
	// Two rows and four columns.
	
	// Time: O(n^2), Space: O(1);
	// loop over the matrix and count the number of islands;
	// if the current dot is an island, count if it has any right neighbour or down neighbour;
	// the result is islands * 4 - neighbours * 2
	public int islandPerimeter (int[][] grid) {
		
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int island = 0, neighbor = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					island++; // count islands
					if (i < grid.length - 1 && grid[i + 1][j] == 1)
						neighbor++; // count down neighbors
					if (j < grid[0].length - 1 && grid[i][j + 1] == 1)
						neighbor++; // count right neighbors
				}
			}
		}
		return island * 4 - neighbor * 2;
	}
}
