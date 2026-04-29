class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long sum = Long.MIN_VALUE;
        long prefix = 0;
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 0L);
        for(int i = 0; i<nums.length; i++){
            prefix += (long)nums[i];
            int target = (i+1)%k;
            if(map.containsKey(target)) {
                sum = Math.max(sum, prefix-map.get(target));
                map.put(target, Math.min(prefix, map.get(target)));
            } else {
                map.put(target, prefix);
            }
        }
        return sum;

    }
}