class Solution {
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        res = 0;
        dfs(nums, target, 0, 0);
        return res;
    }
    private void dfs(int[] nums, int target, long sum, int idx) {
        if(idx>=nums.length && sum == target){
            res++;
            return;
        }
        
        if(idx>=nums.length) return;
        dfs(nums, target, sum+nums[idx], idx+1);
        dfs(nums, target, sum-nums[idx], idx+1);
    }
}
