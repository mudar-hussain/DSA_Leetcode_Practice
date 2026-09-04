class Solution {
    int[] dp = new int[31];
    public int fib(int n) {
        Arrays.fill(dp, -1);
        return solve(n);
    }
    private int solve(int n) {
        if(n==0 || n==1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = fib(n-1)+fib(n-2);
    }
}