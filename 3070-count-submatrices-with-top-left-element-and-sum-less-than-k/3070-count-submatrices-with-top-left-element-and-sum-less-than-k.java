class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                int top = i>0?grid[i-1][j]:0;
                int left = j>0?grid[i][j-1]:0;
                int dia = i>0 && j>0? grid[i-1][j-1]:0;
                grid[i][j] = grid[i][j] + top + left-dia;
                if(grid[i][j] <= k) count++;
            }
        }
        
        for(int i = 0; i<m; i++){
            System.out.println(Arrays.toString(grid[i]));

        }
        return count;

        
    }
}