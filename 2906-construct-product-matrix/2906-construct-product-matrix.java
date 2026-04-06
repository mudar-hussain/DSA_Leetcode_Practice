class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int MOD = 12345;
        int[][] ans = new int[m][n];
        int[][] suffix = new int[m][n];
        long prefix = 1, suffixProd = 1;
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                suffix[i][j] = (int)suffixProd;
                suffixProd = (suffixProd * grid[i][j]) % MOD;
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
               ans[i][j] = (int)(prefix * suffix[i][j]) % MOD;
               prefix = (prefix * grid[i][j]) % MOD;
            }
        }
        return ans;
        
    }
}