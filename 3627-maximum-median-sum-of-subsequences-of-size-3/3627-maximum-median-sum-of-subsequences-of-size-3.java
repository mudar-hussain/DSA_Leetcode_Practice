class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        long median = 0L;
        int groups = nums.length/3;
        int idx = nums.length-2;
        for(int i = 0; i<groups; i++){
            median += nums[idx];
            idx -= 2;
        }
        return median;
    }
}