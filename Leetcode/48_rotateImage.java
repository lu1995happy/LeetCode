public class rotateMatrix {
	public void rotate(int[][] matrix) {
	    int s = 0, e = matrix.length - 1;
	    while(s < e){
	        int[] temp = matrix[s];
	        matrix[s] = matrix[e];
	        matrix[e] = temp;
	        s++; e--;
	    }

	    for(int i = 0; i < matrix.length; i++){
	        for(int j = i+1; j < matrix[i].length; j++){
	            int temp = matrix[i][j];
	            matrix[i][j] = matrix[j][i];
	            matrix[j][i] = temp;
	        }
	    }
	}
	
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<matrix.length/2;i++){
            for(int j =i;j<n-i-1;j++){
                int temp =matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
    
    public static void main(String[] args) {
    		rotateMatrix matrix = new rotateMatrix();
    		int[][] m = {{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12},
					{13,14,15,16}};
    		matrix.rotate(m);
    		System.out.println(m);
    		System.out.println();
    }
}
