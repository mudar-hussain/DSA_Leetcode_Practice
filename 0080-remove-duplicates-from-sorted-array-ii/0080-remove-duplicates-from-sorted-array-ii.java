class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int count = 1;
        int num = nums[0];
        for(int i = 1; i<nums.length; i++){
            if(num == nums[i]) {
                if(count>=2) continue;
                count++;
            } else {
                count = 1;
                num = nums[i];
            }
            nums[k++] = nums[i];
        }
        return k;
        
    }
}