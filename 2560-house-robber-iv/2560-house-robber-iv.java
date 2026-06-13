class Solution {
    private boolean isPossible(int[] nums, int k, int target) {
        int houses = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i]<=target) {
                houses++;
                i++;
            }
            if(houses>=k) return true;
        }
        return false;
    }
    public int minCapability(int[] nums, int k) {
        int low = 1, high = (int)1e9;
        while(low < high) {
            int mid = low + (high-low)/2;
            if(isPossible(nums, k, mid)) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}