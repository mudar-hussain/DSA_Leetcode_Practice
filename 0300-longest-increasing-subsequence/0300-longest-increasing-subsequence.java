class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1];
        for(int i = 0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(nums, 0, -1);
    }
    private int solve(int[] nums, int curr, int prev) {
        if(curr==nums.length) return 0;
        if(dp[curr][prev+1] != -1) return dp[curr][prev+1];
        int notTake = solve(nums, curr+1, prev);
        int take = 0;
        if(prev ==-1 || nums[curr]>nums[prev]) {
            take = 1 + solve(nums, curr+1, curr);
        } 
        return dp[curr][prev+1] = Math.max(take, notTake);
    }
}