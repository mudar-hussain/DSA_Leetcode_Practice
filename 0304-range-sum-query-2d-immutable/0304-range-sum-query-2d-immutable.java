class NumMatrix {
    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        sumMatrix = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j<n; j++){
                int top = i>0?sumMatrix[i-1][j]:0;
                int left = j>0?sumMatrix[i][j-1]:0;
                int dia = i>0&&j>0?sumMatrix[i-1][j-1]:0;
                sumMatrix[i][j] = matrix[i][j]+top+left-dia;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (sumMatrix[row2][col2]- (col1-1<0? 0 : sumMatrix[row2][col1-1]) 
        - (row1-1<0? 0 : sumMatrix[row1-1][col2]) + ((row1-1<0 || col1-1<0)? 0 : sumMatrix[row1-1][col1-1]));

        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */