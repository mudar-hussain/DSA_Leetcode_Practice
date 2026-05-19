class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low<=high) {
            int mid = low + (high - low) / 2;
            if(nums[low]>nums[high]){
                if(nums[mid]>nums[high]){
                    low = mid+1;
                } else {
                    high = mid;
                }
            } else {
                return nums[low];
            }
        }
        return nums[low];
        
    }
}