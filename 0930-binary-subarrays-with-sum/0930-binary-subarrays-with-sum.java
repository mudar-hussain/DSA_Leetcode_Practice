class Solution {
    private int atMost(int[] nums, int goal) {
        int n = nums.length;
        int left = 0, right = 0, sum = 0, count = 0;
        while(right<n) {
            sum+=nums[right];
            while(left<=right && sum > goal) {
                sum -= nums[left++];
            }
            count += right-left+1;
            right++;
        }
        return count;

    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal-1);
    }
}