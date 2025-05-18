class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        // while(l<nums.length && nums[l] == 0) {
        //     l++;
        // }
        // while(h>=0 && nums[h] == 2) {
        //     h--;
        // }
        int m = 0;
        while(m<=h) {
            if(nums[m] == 0) {
                swap(nums, l, m);
                l++;
                m++;
            } else if (nums[m] == 2) {
                swap(nums, m, h);
                h--;
            } else {
                m++;
            }
        }
    }
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}