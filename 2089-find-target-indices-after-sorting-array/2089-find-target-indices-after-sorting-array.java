class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int less = 0, count = 0;
        for(int num: nums) {
            if(num<target) less++;
            if(num == target) count++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<count; i++) {
            res.add(less + i);
        }
        return res;        
    }
}