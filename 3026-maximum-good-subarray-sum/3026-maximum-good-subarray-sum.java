class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Long> map  = new HashMap<>();
        long maxSum = Long.MIN_VALUE;
        long prefixSum = 0;
        for(int num: nums) {
            if(map.containsKey(num-k)) {
                long currMinSum = map.get(num-k);
                maxSum = Math.max(maxSum, prefixSum + num - currMinSum);
            }
            if(map.containsKey(num+k)) {
                long currMinSum = map.get(num+k);
                maxSum = Math.max(maxSum, prefixSum + num - currMinSum);
            }
            long currMinSum = Math.min(map.getOrDefault(num, Long.MAX_VALUE), prefixSum);
            map.put(num, currMinSum);
            prefixSum += num;
        }
        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
        
    }
}