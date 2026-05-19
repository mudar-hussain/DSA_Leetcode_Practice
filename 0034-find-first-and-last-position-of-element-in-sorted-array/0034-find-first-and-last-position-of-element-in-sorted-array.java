class Solution {
    public int[] searchRange(int[] nums, int target) {
        int less = 0, count = 0;
        for(int num: nums) {
            if(num<target) less++;
            if(num == target) count++;
        }
        int[] res = new int[2];
        if(count>0) {
            res[0] = less;
            if(count>1) res[1] = less+count-1;
            else res[1] = less;
        } else {
            res[0] = -1;
            res[1] = -1;
        }
        
        return res;  
        
    }
}