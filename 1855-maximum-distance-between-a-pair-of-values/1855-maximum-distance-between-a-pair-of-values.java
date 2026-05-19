class Solution {
    // private int binary(int[] nums, int i, int target) {
    //     int low = i, high = nums.length-1;
    //     int idx = i-1;
    //     while(low<=high) {
    //         int mid = low + (high-low)/2;
    //         if(nums[mid] >= target) {
    //             low = mid+1;
    //             idx = mid;
    //         } else high = mid-1;
    //     }
    //     return idx;
    // }
    // public int maxDistance(int[] nums1, int[] nums2) {
    //     int maxDist = 0;
    //     for(int i = 0; i<nums1.length; i++){
    //         maxDist = Math.max(maxDist, binary(nums2, i, nums1[i])-i);
    //     }
    //     return maxDist;

    // }
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDist = 0;
        int i = 0, j = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]) {
                maxDist = Math.max(maxDist, j-i);
                j++;
            } else i++;

        }
        return maxDist;

    }
}