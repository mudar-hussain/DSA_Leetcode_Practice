class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        int ones = 0, zeros = 0;
        int res = 0;
        while(right<n) {
            while(right<n && zeros <= 1) {
                if(nums[right++] == 0) zeros++;
                else ones++;
            }
            res = Math.max(res, ones);
            while(left<=right && zeros>1) {
                if(nums[left++] == 1) ones--;
                else zeros--;
            }
            
        }
        return res==n?res-1:res;
    }
}