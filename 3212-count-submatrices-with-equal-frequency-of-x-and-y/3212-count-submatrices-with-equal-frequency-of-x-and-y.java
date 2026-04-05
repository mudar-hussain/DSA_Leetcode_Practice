class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        int[] countXX = new int[n];
        int[] countXY = new int[n];
        int countYX = 0;
        int countYY = 0;
        for(int i = 0; i<m; i++){
            countYX = 0;
            countYY = 0;
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 'X') countXX[j]++;
                else if(grid[i][j] == 'Y') countXY[j]++;
                if(countYX+countXX[j]>0 && countYX+countXX[j] == countYY+countXY[j]) res++;
                countYX += countXX[j];
                countYY += countXY[j];
            }

        }
        return res;
        

        
    }
}