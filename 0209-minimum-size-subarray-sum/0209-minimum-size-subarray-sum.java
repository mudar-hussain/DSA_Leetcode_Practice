class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for(int j = 0; j<nums.length; j++) {
            sum += nums[j];
            while(sum>=target) {
                ans = Math.min(ans, j-i+1);
                sum -= nums[i++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}