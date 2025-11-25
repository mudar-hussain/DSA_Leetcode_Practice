class Solution {
    public int removeDuplicates(int[] nums) {
        int max = -101;
        int idx = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i]>max) {
                nums[idx] = nums[i];
                max = nums[i];
                idx++;
            }
        }
        return idx;
    }
}