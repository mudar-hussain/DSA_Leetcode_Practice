class Solution {
    int k = 0;
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void update(int[] nums, int target) {
        for(int i = k; i<nums.length; i++){
            if(nums[i] == target) {
                swap(nums, i, k);
                k++;
            }
        }
    }
    public void sortColors(int[] nums) {
        update(nums, 0);
        update(nums, 1);
        update(nums, 2);
    }
}