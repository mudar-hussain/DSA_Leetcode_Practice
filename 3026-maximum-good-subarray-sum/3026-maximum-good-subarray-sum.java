class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Long res = Long.MIN_VALUE;
        Long val;
        long sum = 0;
        Map<Integer, Long> map = new HashMap<>();
        for(int num: nums){
            val = map.get(num);
            if(val == null || val>sum) map.put(num, sum);
            sum+=num;
            val = map.get(num+k);
            if(val!=null) res = Math.max(res, sum-val);
            val = map.get(num-k);
            if(val!=null) res = Math.max(res, sum-val);
        }
        return res == Long.MIN_VALUE ? 0 : res;
        
    }
}