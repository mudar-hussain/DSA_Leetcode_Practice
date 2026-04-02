class Solution {
    int m, n;
    Integer[][][] dp;
    public int maximumAmount(int[][] coins) {
        //Approach 1. Pure Recursion (Brute Force)
        // return calcAmountRecursion(coins, 0, 0, 2);

        //Approach 2. Memoization (Top-Down DP)
        m = coins.length;
        n = coins[0].length;
        dp = new Integer[m][n][3];
        return calcAmountDp(coins, 0, 0, 2);

        //Approach 3. Tabulation (Bottom-Up DP)


    }
    private int calcAmountDp(int[][] coins, int i, int j, int ability){
        if(i>=m || j>=n){
            return Integer.MIN_VALUE;
        }
        if(dp[i][j][ability] != null) return dp[i][j][ability];
        
        int val = coins[i][j];
        if (i == m - 1 && j == n - 1) {
            if (val < 0 && ability > 0) return 0;
            return val;
        }

        int take = val + Math.max(
            calcAmountDp(coins, i, j+1, ability),
            calcAmountDp(coins, i+1, j, ability)
        );
        int skip = Integer.MIN_VALUE;
        if(val<0 && ability>0) {
            skip = Math.max(
                calcAmountDp(coins, i, j+1, ability-1),
                calcAmountDp(coins, i+1, j, ability-1)
            );
        }
        return dp[i][j][ability] = Math.max(take, skip);
    }
    
    private int calcAmountRecursion(int[][] coins, int i, int j, int ability){
        int m = coins.length, n = coins[0].length;
        if(i>=m || j>=n) {
            return Integer.MIN_VALUE;
        }
        int val = coins[i][j];
        if (i == m - 1 && j == n - 1) {
            if (val < 0 && ability > 0) return 0;
            return val;
        }

        int take = val + Math.max(
            calcAmountRecursion(coins, i, j+1, ability),
            calcAmountRecursion(coins, i+1, j, ability)
        );
        int skip = Integer.MIN_VALUE;
        if(val<0 && ability>0) {
            skip = Math.max(
                calcAmountRecursion(coins, i, j+1, ability-1),
                calcAmountRecursion(coins, i+1, j, ability-1)
            );
        }
        return Math.max(take, skip);
    }
}