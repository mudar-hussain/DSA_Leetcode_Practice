class Solution {
    int[][] dp;
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        dp = new int[pairs.length][pairs.length+1];
        for(int i = 0; i<pairs.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solve(pairs, 0, -1);
    }
    private int solve(int[][] pairs, int idx, int prev) {
        if(idx>=pairs.length) return 0;
        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
        int notTake = solve(pairs, idx+1, prev);
        int take = 0;
        if(prev==-1 || pairs[idx][0]>pairs[prev][1]) {
            take = 1 + solve(pairs, idx+1, idx);
        }
        return dp[idx][prev+1] = Math.max(take, notTake);

    }
}