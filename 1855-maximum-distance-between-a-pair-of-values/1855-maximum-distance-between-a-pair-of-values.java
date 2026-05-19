class Solution {
    private int binary(int[] nums, int i, int target) {
        int low = i, high = nums.length-1;
        int idx = i;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid] >= target) {
                low = mid+1;
                idx = mid;
            } else high = mid-1;
        }
        return idx;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDist = 0;
        for(int i = 0; i<nums1.length; i++){
            maxDist = Math.max(maxDist, binary(nums2, i, nums1[i])-i);
        }
        return maxDist;

    }
}