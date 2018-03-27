
public class rangeSumQuery2D_Mutable {

	int[][] nums;
	int[][] BIT;
	int n;
	int m;
	
	// Time: O(n * logn * m * logm);
	// binary indexed tree
    public rangeSumQuery2D_Mutable(int[][] matrix) {
    		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
    			return;
        n = matrix.length;
        m = matrix[0].length;
        nums = new int[n][m];
        BIT = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) 
        		for (int j = 0; j < m; j++)
        			update(i, j, matrix[i][j]);
    }
    
    // Time: O(logn * logm);
    public void update(int row, int col, int val) {
        if (n == 0 || m == 0)
        		return;
        int diff = val - nums[row][col];
        nums[row][col] = val;
        for (int i = row + 1; i <= n; i += i & (-i)) {
        		for (int j = col + 1; j <= m; j += j & (-j)) {
        			BIT[i][j] += diff;
        		}
        }
    }
    
    // Time: O(logn * logm);
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (n == 0 || m == 0)
        		return 0;
        return sum(row2 + 1, col2 + 1) + sum(row1, col1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
    }
    
    public int sum(int row, int col) {
    		int sum = 0;
    		for (int i = row; i > 0; i -= i & (-i)) {
    			for (int j = col; j > 0; j-= j & (-j)) {
    				sum += BIT[i][j];
    			}
    		}
    		return sum;
    }
    
    // segment tree
    TreeNode root;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            root = null;
        } else {
            root = buildTree(matrix, 0, 0, matrix.length-1, matrix[0].length-1);
        }
    }

    public void update(int row, int col, int val) {
        update(root, row, col, val);
    }

    private void update(TreeNode root, int row, int col, int val) {
        if (root.row1 == root.row2 && root.row1 == row && root.col1 == root.col2 && root.col1 == col) {
            root.sum = val;
            return;
        }
        int rowMid = (root.row1 + root.row2) / 2;
        int colMid = (root.col1 + root.col2) / 2;
        TreeNode next;
        if (row <= rowMid) {
            if (col <= colMid) {
                next = root.c1;
            } else {
                next = root.c2;
            }
        } else {
            if (col <= colMid) {
                next = root.c3;
            } else {
                next = root.c4;
            }
        }
        root.sum -= next.sum;
        update(next, row, col, val);
        root.sum += next.sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion(root, row1, col1, row2, col2);
    }

    private int sumRegion(TreeNode root, int row1, int col1, int row2, int col2) {
        if (root.row1 == row1 && root.col1 == col1 && root.row2 == row2 && root.col2 == col2)
            return root.sum;
        int rowMid = (root.row1 + root.row2) / 2;
        int colMid = (root.col1 + root.col2) / 2;
        if (rowMid >= row2) {
            if (colMid >= col2) {
                return sumRegion(root.c1, row1, col1, row2, col2);
            } else if (colMid + 1 <= col1) {
                return sumRegion(root.c2, row1, col1, row2, col2);
            } else {
                return sumRegion(root.c1, row1, col1, row2, colMid) + sumRegion(root.c2, row1, colMid+1, row2, col2);
            }
        } else if (rowMid + 1 <= row1) {
            if (colMid >= col2) {
                return sumRegion(root.c3, row1, col1, row2, col2);
            } else if (colMid + 1 <= col1) {
                return sumRegion(root.c4, row1, col1, row2, col2);
            } else {
                return sumRegion(root.c3, row1, col1, row2, colMid) + sumRegion(root.c4, row1, colMid+1, row2, col2);
            }
        } else {
            if (colMid >= col2) {
                return sumRegion(root.c1, row1, col1, rowMid, col2) + sumRegion(root.c3, rowMid+1, col1, row2, col2);
            } else if (colMid + 1 <= col1) {
                return sumRegion(root.c2, row1, col1, rowMid, col2) + sumRegion(root.c4, rowMid+1, col1, row2, col2);
            } else {
                return sumRegion(root.c1, row1, col1, rowMid, colMid) + sumRegion(root.c2, row1, colMid+1, rowMid, col2) + sumRegion(root.c3, rowMid+1, col1, row2, colMid) + sumRegion(root.c4, rowMid+1, colMid+1, row2, col2);
            }
        }
    }

    private TreeNode buildTree(int[][] matrix, int row1, int col1, int row2, int col2) {
        if (row2 < row1 || col2 < col1)
            return null;
        TreeNode node = new TreeNode(row1, col1, row2, col2);
        if (row1 == row2 && col1 == col2) {
            node.sum = matrix[row1][col1];
            return node;
        }
        int rowMid = (row1 + row2) / 2;
        int colMid = (col1 + col2) / 2;
        node.c1 = buildTree(matrix, row1, col1, rowMid, colMid);
        node.c2 = buildTree(matrix, row1, colMid+1, rowMid, col2);
        node.c3 = buildTree(matrix, rowMid+1, col1, row2, colMid);
        node.c4 = buildTree(matrix, rowMid+1, colMid+1, row2, col2);
        node.sum += node.c1 != null ? node.c1.sum : 0;
        node.sum += node.c2 != null ? node.c2.sum : 0;
        node.sum += node.c3 != null ? node.c3.sum : 0;
        node.sum += node.c4 != null ? node.c4.sum : 0;
        return node;
    }

    public class TreeNode {
        int row1, row2, col1, col2, sum;
        TreeNode c1, c2, c3, c4;
        public TreeNode (int row1, int col1, int row2, int col2) {
            this.row1 = row1;
            this.col1 = col1;
            this.row2 = row2;
            this.col2 = col2;
            this.sum = 0;
        }
    }
}



/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
