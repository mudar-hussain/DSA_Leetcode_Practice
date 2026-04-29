class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long sum = Long.MIN_VALUE;
        long prefix = 0;
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE);
        minPrefix[0] = 0;
        for(int i = 0; i<nums.length; i++){
            prefix += (long)nums[i];
            int target = (i+1)%k;
            if(minPrefix[target]!=Long.MAX_VALUE) {
                sum = Math.max(sum, prefix-minPrefix[target]);
            }
            minPrefix[target] = Math.min(prefix, minPrefix[target]);
        }
        return sum;

    }
}