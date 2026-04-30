class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long prefix = 0;
        long maxSum = Long.MIN_VALUE;
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE);
        minPrefix[0] = 0;
        for(int i = 0; i<nums.length; i++) {
            prefix += nums[i];
            int target = (i+1)%k;
            if(minPrefix[target] != Long.MAX_VALUE) {
                maxSum = Math.max(maxSum, prefix-minPrefix[target]);
            }
            minPrefix[target] = Math.min(minPrefix[target], prefix);
        }
        return maxSum;

    }
}