class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        long prefix = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        for(int i = 0; i<nums.length; i++) {
            prefix += nums[i];
            long target = (prefix+k)%k;
            if(map.containsKey(target)) {
                if(i-map.get(target)>=2) return true;
            } 
            else map.put(target, i);
        }
        return false;
    }
}