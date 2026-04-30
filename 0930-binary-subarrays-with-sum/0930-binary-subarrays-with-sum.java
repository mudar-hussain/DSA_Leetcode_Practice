class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefix = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int num: nums) {
            prefix += num;
            int target = prefix-goal;
            if(map.containsKey(target)){
                count += map.get(target);
            }
            map.put(prefix, map.getOrDefault(prefix,0)+1);
        }
        return count;
        
    }
}